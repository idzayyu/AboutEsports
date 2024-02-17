package com.example.aboutesports.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aboutesports.R
import com.example.aboutesports.Repo.dataBin.Match
import com.example.aboutesports.Repo.dataBin.Tournaments
import com.example.aboutesports.Repo.dataTest.NewsTest
import com.example.aboutesports.Repo.dataTest.PlaysTest
import com.example.aboutesports.Repo.dataTest.TournamentsTest
import com.example.aboutesports.adapters.MatchAdapter
import com.example.aboutesports.adapters.TournamentsAdapter
import com.example.aboutesports.databinding.FragmentMatchListBinding
import com.example.aboutesports.databinding.FragmentPlaysListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MatchListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MatchListFragment : Fragment() {

    private var _binding: FragmentMatchListBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMatchListBinding.inflate(inflater, container, false)

        val playsLst = PlaysTest.mapPlayTour[arguments?.getInt("tournamentsId") ?: 0]?: listOf()

        val adapter = MatchAdapter(playsLst, object : MatchAdapter.MatchClickListener {
            override fun onTestClicked(match: Match) {
                binding.root.findNavController().navigate(R.id.action_matchListFragment_to_matchFragment, bundleOf("matchId" to  match.id))
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
         * @return A new instance of fragment MatchListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MatchListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}