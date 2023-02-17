package com.example.news.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news.data.models.News
import com.example.news.databinding.ItemNewsBinding

class NewsAdapter :
    ListAdapter<News, NewsAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: News) = with(binding) {
            Glide.with(imView.context)
                .load(item.urlToImage)
                .into(imView)
            binding.tvNameItem.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem == newItem
            }
        }
    }
}