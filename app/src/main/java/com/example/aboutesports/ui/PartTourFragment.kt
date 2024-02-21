package com.example.aboutesports.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aboutesports.R
import com.example.aboutesports.Repo.dataBin.PartTour
import com.example.aboutesports.Repo.dataTest.TournamentsTest
import com.example.aboutesports.adapters.MyPartTourRecyclerViewAdapter
import com.example.aboutesports.databinding.FragmentItemListBinding

/**
 * A fragment representing a list of Items.
 */
class PartTourFragment : Fragment() {

    private var columnCount = 1
    private var _binding: FragmentItemListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
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
        if (tournament.imageHeadUrl != null ) {
            Glide.with(binding.artMovie)
                .load(tournament.imageHeadUrl)
                .optionalCenterCrop()
                .into(binding.artMovie)
        }
        with(binding){
            review.setTextColor(Color.RED)
            review.setBackgroundResource(R.drawable.button_pressed_bg)
            review.setOnClickListener{
                review.setTextColor(Color.RED)
                review.setBackgroundResource(R.drawable.button_pressed_bg)
                Rules.setTextColor(Color.WHITE)
                Participants.setTextColor(Color.WHITE)
                Grid.setTextColor(Color.WHITE)
                Rules.background = null
                Participants.background = null
                Grid.background = null
            }
            Rules.setOnClickListener{
                Rules.setTextColor(Color.RED)
                Rules.setBackgroundResource(R.drawable.button_pressed_bg)
                review.setTextColor(Color.WHITE)
                Participants.setTextColor(Color.WHITE)
                Grid.setTextColor(Color.WHITE)
                review.background = null
                Participants.background = null
                Grid.background = null
                myTextView.text = tournament.rules
            }
            Participants.setOnClickListener{
                Participants.setTextColor(Color.RED)
                Participants.setBackgroundResource(R.drawable.button_pressed_bg)
                review.setTextColor(Color.WHITE)
                Rules.setTextColor(Color.WHITE)
                Grid.setTextColor(Color.WHITE)
                review.background = null
                Rules.background = null
                Grid.background = null
            }
            Grid.setOnClickListener{
                Grid.setTextColor(Color.RED)
                Grid.setBackgroundResource(R.drawable.button_pressed_bg)
                review.setTextColor(Color.WHITE)
                Participants.setTextColor(Color.WHITE)
                Rules.setTextColor(Color.WHITE)
                review.background = null
                Participants.background = null
                Rules.background = null
            }
        }


        return binding.root
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            PartTourFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}