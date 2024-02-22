package com.example.aboutesports.ui.tournaments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aboutesports.R
import com.example.aboutesports.Repo.dataBin.Tournaments
import com.example.aboutesports.Repo.dataTest.TournamentsTest.lstTest1
import com.example.aboutesports.Repo.dataTest.TournamentsTest
import com.example.aboutesports.adapters.TournamentsAdapter
import com.example.aboutesports.databinding.FragmentTournamentsBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import java.time.LocalDateTime

class TournamentsFragment : Fragment() {

    private var _binding: FragmentTournamentsBinding? = null

    private val binding get() = _binding!!
    lateinit var  drawerLayout: DrawerLayout
    lateinit var  navigationView: NavigationView
    lateinit var  toolbar: MaterialToolbar
    val currentDate = LocalDateTime.now()
    private val adapter = TournamentsAdapter(lstTest1, object : TournamentsAdapter.TournamentsClickListener {
        override fun onTestClicked(tournaments: Tournaments) {
            binding.root.findNavController().navigate(R.id.action_navigation_tournaments_to_partTourFragment, bundleOf("tournamentsId" to tournaments.id))
        }
    })
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


        val layoutManager = LinearLayoutManager(requireActivity())
        binding.rw.layoutManager = layoutManager
        binding.rw.adapter = adapter

        with(binding) {
            future.setTextColor(Color.RED)
            future.setBackgroundResource(R.drawable.button_pressed_bg)

            // Обработчик для всех кнопок
            val buttonClickListener: (Button, LocalDateTime) -> Unit = { button, filterDate ->
                val filteredList = when(button) {
                    current -> lstTest1.filter { it.time.isBefore(currentDate)}
                    past -> lstTest1.filter { it.time.isBefore(currentDate) }
                    future -> lstTest1.filter { it.time.isAfter(currentDate) }
                    else -> emptyList()  // Обработка других кнопок, если это необходимо
                }
                adapter.updateData(filteredList)
                resetButtonStates()
                button.setTextColor(Color.RED)
                button.setBackgroundResource(R.drawable.button_pressed_bg)
            }

            current.setOnClickListener { buttonClickListener.invoke(current, currentDate) }
            past.setOnClickListener { buttonClickListener.invoke(past, currentDate) }
            future.setOnClickListener { buttonClickListener.invoke(future, currentDate) }
        }

        return binding.root
    }
    private fun resetButtonStates() {
        with(binding) {
            current.setTextColor(Color.WHITE)
            past.setTextColor(Color.WHITE)
            future.setTextColor(Color.WHITE)

            current.background = null
            past.background = null
            future.background = null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}