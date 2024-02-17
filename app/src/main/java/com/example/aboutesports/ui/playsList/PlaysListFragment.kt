package com.example.aboutesports.ui.playsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aboutesports.R
import com.example.aboutesports.Repo.dataBin.Tournaments
import com.example.aboutesports.Repo.dataTest.TournamentsTest
import com.example.aboutesports.adapters.TournamentsAdapter
import com.example.aboutesports.databinding.FragmentPlaysListBinding
import com.example.aboutesports.databinding.FragmentTournamentsBinding

/**
 * A simple [Fragment] subclass.
 * Use the [PlaysListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlaysListFragment : Fragment() {

    private var _binding: FragmentPlaysListBinding? = null

    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPlaysListBinding.inflate(inflater, container, false)

        val adapter = TournamentsAdapter(TournamentsTest.lstTest1, object : TournamentsAdapter.TournamentsClickListener {
            override fun onTestClicked(tournaments: Tournaments) {
                binding.root.findNavController().navigate(R.id.action_navigation_plays_to_matchListFragment, bundleOf("tournamentsId" to  tournaments.id))
            }
        })

        val layoutManager = LinearLayoutManager(requireActivity())

        binding.rw.layoutManager = layoutManager
        binding.rw.adapter = adapter
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PlaysListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlaysListFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}