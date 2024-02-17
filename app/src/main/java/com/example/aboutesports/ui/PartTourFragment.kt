package com.example.aboutesports.ui

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

        // Set the adapter

        val adapter = MyPartTourRecyclerViewAdapter(tournament.partList, object : MyPartTourRecyclerViewAdapter.PartTourClickListener {
                    override fun onTestClicked(partTour: PartTour) {
                        binding.root.findNavController().navigate(R.id.action_partTourFragment_to_infoStageFragment, bundleOf("newsId" to  partTour.id))
                    }
                })


        val layoutManager = LinearLayoutManager(requireActivity())

        binding.rw.layoutManager = layoutManager
        binding.rw.adapter = adapter

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