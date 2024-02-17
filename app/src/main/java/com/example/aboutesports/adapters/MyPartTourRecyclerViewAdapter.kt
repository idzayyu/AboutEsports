package com.example.aboutesports.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.aboutesports.R
import com.example.aboutesports.Repo.dataBin.News
import com.example.aboutesports.Repo.dataBin.PartTour

import com.example.aboutesports.ui.placeholder.PlaceholderContent.PlaceholderItem
import com.example.aboutesports.databinding.FragmentItemBinding
import com.example.aboutesports.databinding.NewsHeadBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyPartTourRecyclerViewAdapter(
    private val partList: List<PartTour>, private val listener: PartTourClickListener
) : RecyclerView.Adapter<MyPartTourRecyclerViewAdapter.ViewHolder>() {


    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = NewsHeadBinding.bind(item)

        fun bind(
            partTour: PartTour,
            listener: PartTourClickListener
        ) = with(binding) {
            time.text = partTour.text
            name.text = partTour.head

            binding.root.setOnClickListener {
                listener.onTestClicked(partTour)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.tournament_head, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(partList[position], listener)
    }

    override fun getItemCount(): Int {
        return partList.size
    }

    interface PartTourClickListener {
        fun onTestClicked(partTour: PartTour)
    }
}