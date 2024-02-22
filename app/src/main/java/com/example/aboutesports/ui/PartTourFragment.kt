package com.example.aboutesports.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aboutesports.R
import com.example.aboutesports.Repo.dataTest.TournamentsTest
import com.example.aboutesports.Repo.fireBase.DbManager
import com.example.aboutesports.databinding.FragmentItemListBinding

/**
 * A fragment representing a list of Items.
 */
class PartTourFragment : Fragment() {

    private var columnCount = 1
    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tournament = TournamentsTest.lstTest1[(arguments?.getInt("tournamentsId")?.minus(1)) ?: 0]
        _binding = FragmentItemListBinding.inflate(inflater, container, false)

        if (tournament.imageHeadUrl != null) {
            Glide.with(binding.artMovie)
                .load(tournament.imageHeadUrl)
                .optionalCenterCrop()
                .into(binding.artMovie)
        }

        tournament.review?.let { setupButton(binding.review, it, binding) }
        updateButtonStates(binding.review)
        tournament.review?.let { updateTextView(it) }   // Обновление текстового поля

        with(binding) {

            addToTournament.setOnClickListener{
                val dbM = DbManager()
                dbM.publishAddTour()
                addToTournament.text = "Отменить регистрацию"
                Toast.makeText(requireContext(),"Вы заргистрированны в турнире!", Toast.LENGTH_SHORT).show()
            }
            tournament.review?.let { setupButton(review, it, binding) }
            setupButton(Rules, tournament.rules, binding)
            setupButton(
                Participants,
                "${tournament.participants} ${tournament.playerList.size} игроков",
                binding
            )
            setupButton(Grid, tournament.draw, binding)
        }


        return binding.root
    }

    private fun setupButton(button: Button, text: String, binding: FragmentItemListBinding) {
        button.setOnClickListener {
            updateButtonStates(button)
            this.binding.addToTournament.visibility = if (button == binding.Rules || button == binding.Participants || button == binding.Grid) View.GONE else View.VISIBLE
            this.binding.myTextView.text = text
        }
    }

    private fun updateButtonStates(clickedButton: Button) {
        val buttons = arrayOf(binding.review, binding.Rules, binding.Participants, binding.Grid)

        buttons.forEach { button ->
            button.setTextColor(if (button == clickedButton) Color.RED else Color.WHITE)
            button.setBackgroundResource(if (button == clickedButton) R.drawable.button_pressed_bg else 0)
        }
    }
    private fun updateTextView(text: String) {
        binding.addToTournament.visibility = View.VISIBLE
        binding.myTextView.text = text
    }

    companion object {
        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) = PartTourFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_COLUMN_COUNT, columnCount)
            }
        }
    }
}