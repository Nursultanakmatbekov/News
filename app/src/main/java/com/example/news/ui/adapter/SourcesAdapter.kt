package com.example.news.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news.data.models.news.News
import com.example.news.data.models.sources.SourcesItem
import com.example.news.databinding.ItemNewsBinding
import com.example.news.databinding.ItemSourcesBinding

class SourcesAdapter :
    ListAdapter<SourcesItem, SourcesAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemSourcesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: SourcesItem) = with(binding) {
            binding.tvNameItem.text = item.name
            binding.tvTitleItem.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSourcesBinding.inflate(
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
        val diffUtil = object : DiffUtil.ItemCallback<SourcesItem>() {
            override fun areItemsTheSame(oldItem: SourcesItem, newItem: SourcesItem): Boolean {
                return oldItem.description == newItem.description
            }

            override fun areContentsTheSame(oldItem: SourcesItem, newItem: SourcesItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}