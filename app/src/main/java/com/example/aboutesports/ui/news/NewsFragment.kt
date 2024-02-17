package com.example.aboutesports.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aboutesports.R
import com.example.aboutesports.Repo.dataBin.News
import com.example.aboutesports.Repo.dataTest.NewsTest
import com.example.aboutesports.adapters.NewsAdapter
import com.example.aboutesports.databinding.FragmentNewsBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var  drawerLayout: DrawerLayout
    lateinit var  navigationView: NavigationView
    lateinit var  toolbar: MaterialToolbar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val newsViewModel =
            ViewModelProvider(this)[NewsViewModel::class.java]

        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        drawerLayout = binding.dr
        navigationView = binding.menu
        toolbar = binding.homeMaterialToolbar

        toolbar.setNavigationOnClickListener{
            drawerLayout.openDrawer(GravityCompat.START
            )
        }
        toolbar.setOnClickListener{
            drawerLayout.openDrawer(GravityCompat.START
            )
        }

        val adapter = NewsAdapter(NewsTest.lstTest1, object : NewsAdapter.NewsClickListener {
            override fun onTestClicked(news: News) {
                binding.root.findNavController().navigate(R.id.action_navigation_home_to_news_max_Fragment, bundleOf("newsId" to  news.id))
            }
        })

        val layoutManager = LinearLayoutManager(requireActivity())

        binding.rw.layoutManager = layoutManager
        binding.rw.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}