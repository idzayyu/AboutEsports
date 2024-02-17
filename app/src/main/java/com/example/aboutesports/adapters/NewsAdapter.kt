package com.example.aboutesports.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aboutesports.R
import com.example.aboutesports.Repo.dataBin.News
import com.example.aboutesports.databinding.NewsHeadBinding

class NewsAdapter(
    private val partList: List<News>, private val listener: NewsClickListener
) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {


    inner class NewsHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = NewsHeadBinding.bind(item)

        fun bind(
            news: News,
            listener: NewsClickListener
        ) = with(binding) {
            time.text = news.time.toString()
            name.text = news.head
            if (news.imageUrl != null ) {
                Glide.with(imageView)
                    .load(news.imageUrl)
                    .optionalCenterCrop()
                    .into(imageView)
                imageView.visibility = View.VISIBLE
            }
            binding.root.setOnClickListener {
                listener.onTestClicked(news)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.news_head, parent, false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bind(partList[position], listener)
    }

    override fun getItemCount(): Int {
        return partList.size
    }

    interface NewsClickListener {
        fun onTestClicked(news: News)
    }
}