package com.example.aboutesports.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aboutesports.R
import com.example.aboutesports.Repo.dataBin.Match
import com.example.aboutesports.Repo.dataBin.News
import com.example.aboutesports.Repo.dataTest.TeamTest
import com.example.aboutesports.databinding.MatchHeadBinding
import com.example.aboutesports.databinding.NewsHeadBinding

class MatchAdapter(
    private val partList: List<Match>, private val listener: MatchClickListener
) : RecyclerView.Adapter<MatchAdapter.MatchHolder>() {


    inner class MatchHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = MatchHeadBinding.bind(item)

        fun bind(
            match: Match,
            listener: MatchClickListener
        ) = with(binding) {
            if (match.head == ""){
                time.text = match.time.toString()
            }
            else
                time.text = match.head

            val teamH = TeamTest.lstTest1[match.homeTeam -1]
            val teamG = TeamTest.lstTest1[match.guestTeam -1]
            teamHome.text = teamH.name
            teamGuest.text = teamG.name
            Glide.with(teamGuestImage)
                .load(teamG.imageUrl)
                .optionalCenterCrop()
                .into(teamGuestImage)

            Glide.with(teamHomeImage)
                .load(teamH.imageUrl)
                .optionalCenterCrop()
                .into(teamHomeImage)

            root.setOnClickListener {
                listener.onTestClicked(match)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.match_head, parent, false)
        return MatchHolder(view)
    }

    override fun onBindViewHolder(holder: MatchHolder, position: Int) {
        holder.bind(partList[position], listener)
    }

    override fun getItemCount(): Int {
        return partList.size
    }

    interface MatchClickListener {
        fun onTestClicked(match: Match)
    }
}