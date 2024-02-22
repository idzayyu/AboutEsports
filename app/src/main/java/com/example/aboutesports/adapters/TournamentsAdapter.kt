package com.example.aboutesports.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aboutesports.R
import com.example.aboutesports.Repo.dataBin.News
import com.example.aboutesports.Repo.dataBin.Tournaments
import com.example.aboutesports.databinding.NewsHeadBinding
import com.example.aboutesports.databinding.TournamentHeadBinding
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class TournamentsAdapter(
    private val partList: List<Tournaments>, private val listener: TournamentsClickListener
) : RecyclerView.Adapter<TournamentsAdapter.TournamentsHolder>() {


    inner class TournamentsHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = TournamentHeadBinding.bind(item)

        val formatter = DateTimeFormatter.ofPattern("dd-MM")
        val today = LocalDateTime.now()
        fun bind(
            tournaments: Tournaments,
            listener: TournamentsClickListener
        ) = with(binding) {
            time.text = tournaments.time.toString()
            name.text = tournaments.head
            region.text = tournaments.text
            time.text = tournaments.time.format(formatter)
            timeForRegistration.text =
                "До старта: " + ChronoUnit.DAYS.between(today, tournaments.time)
                    .toString() + " д."
            if (tournaments.imageUrl != null) {
                Glide.with(imageView)
                    .load(tournaments.imageUrl)
                    .circleCrop()
                    .into(imageView)
                imageView.visibility = View.VISIBLE
            }
            binding.root.setOnClickListener {
                listener.onTestClicked(tournaments)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentsHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.tournament_head, parent, false)
        return TournamentsHolder(view)
    }

    override fun onBindViewHolder(holder: TournamentsHolder, position: Int) {
        holder.bind(partList[position], listener)
    }

    override fun getItemCount(): Int {
        return partList.size
    }

    interface TournamentsClickListener {
        fun onTestClicked(tournaments: Tournaments)
    }
}