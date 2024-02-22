package com.example.aboutesports.ui.tournaments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aboutesports.R
import com.example.aboutesports.Repo.dataBin.News
import com.example.aboutesports.Repo.dataBin.Tournaments
import com.example.aboutesports.Repo.dataTest.NewsTest
import com.example.aboutesports.Repo.dataTest.TournamentsTest
import com.example.aboutesports.adapters.NewsAdapter
import com.example.aboutesports.adapters.TournamentsAdapter
import com.example.aboutesports.databinding.FragmentNewsBinding
import com.example.aboutesports.databinding.FragmentTournamentsBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class TournamentsFragment : Fragment() {

    private var _binding: FragmentTournamentsBinding? = null

    private val binding get() = _binding!!
    lateinit var  drawerLayout: DrawerLayout
    lateinit var  navigationView: NavigationView
    lateinit var  toolbar: MaterialToolbar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTournamentsBinding.inflate(inflater, container, false)
        drawerLayout = binding.dr
        navigationView = binding.menu
        toolbar = binding.homeMaterialToolbar

        toolbar.setNavigationOnClickListener{
            drawerLayout.openDrawer(
                GravityCompat.START
            )
        }
        toolbar.setOnClickListener{
            drawerLayout.openDrawer(
                GravityCompat.START
            )
        }

        val adapter = TournamentsAdapter(TournamentsTest.lstTest1, object : TournamentsAdapter.TournamentsClickListener {
            override fun onTestClicked(tournaments: Tournaments) {
                binding.root.findNavController().navigate(R.id.action_navigation_tournaments_to_partTourFragment, bundleOf("tournamentsId" to  tournaments.id))
            }
        })

        val layoutManager = LinearLayoutManager(requireActivity())

        binding.rw.layoutManager = layoutManager
        binding.rw.adapter = adapter
        with(binding){

            current.setOnClickListener{
                current.setTextColor(Color.RED)
                current.setBackgroundResource(R.drawable.button_pressed_bg)
                past.setTextColor(Color.WHITE)
                future.setTextColor(Color.WHITE)
                past.background = null
                future.background = null
            }
            past.setOnClickListener{
                past.setTextColor(Color.RED)
                past.setBackgroundResource(R.drawable.button_pressed_bg)
                current.setTextColor(Color.WHITE)
                future.setTextColor(Color.WHITE)
                current.background = null
                future.background = null
            }
            future.setOnClickListener{
                future.setTextColor(Color.RED)
                future.setBackgroundResource(R.drawable.button_pressed_bg)
                current.setTextColor(Color.WHITE)
                past.setTextColor(Color.WHITE)
                current.background = null
                past.background = null
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}