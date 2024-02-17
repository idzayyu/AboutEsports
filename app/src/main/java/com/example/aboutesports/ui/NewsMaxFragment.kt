package com.example.aboutesports.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.aboutesports.Repo.dataTest.NewsTest
import com.example.aboutesports.databinding.FragmentNewsMaxBinding

class NewsMaxFragment : Fragment() {

    private lateinit var _binding: FragmentNewsMaxBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsMaxBinding.inflate(inflater, container, false)
        val news = NewsTest.lstTest1[(arguments?.getInt("newsId")?.minus(1)) ?: 0]
        if (news.imageUrl != null) {
            Glide.with(_binding.imageView3)
                .load(news.imageUrl)
                .optionalCenterCrop()
                .into(_binding.imageView3)
        }
        _binding.name.text = news.text
        // Inflate the layout for this fragment
        return _binding.root
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsMaxFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}