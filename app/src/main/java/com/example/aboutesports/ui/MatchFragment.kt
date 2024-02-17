package com.example.aboutesports.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.aboutesports.R
import com.example.aboutesports.Repo.dataTest.NewsTest
import com.example.aboutesports.Repo.dataTest.PlaysTest
import com.example.aboutesports.Repo.dataTest.TeamTest
import com.example.aboutesports.databinding.FragmentMatchBinding
import com.example.aboutesports.databinding.FragmentMatchListBinding


class MatchFragment : Fragment() {

    private var _binding: FragmentMatchBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchBinding.inflate(inflater, container, false)

        val match = PlaysTest.lstTest1[(arguments?.getInt("matchId")?.minus(1)) ?: 0]

        binding.resultMatch.text = match.head
        binding.timeMatch.text = match.time.toString()
        binding.stateMatch.text = match.text

        val teamH = TeamTest.lstTest1[match.homeTeam - 1]
        val teamG = TeamTest.lstTest1[match.guestTeam - 1]
        binding.nameHomeTeam.text = teamH.name
        binding.nameGuestTeam.text = teamG.name
        Glide.with(binding.teamGuestImage)
            .load(teamG.imageUrl)
            .optionalCenterCrop()
            .into(binding.teamGuestImage)

        Glide.with(binding.teamHomeImage)
            .load(teamH.imageUrl)
            .optionalCenterCrop()
            .into(binding.teamHomeImage)


        return binding.root
    }


}