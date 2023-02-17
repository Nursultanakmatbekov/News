package com.example.news.ui.fragments.topheadlines

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.news.R
import com.example.news.base.BaseFragment
import com.example.news.databinding.FragmentTopHeadlinesBinding
import com.example.news.ui.adapter.NewsAdapter
import com.example.news.utils.Resources
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopHeadlinesFragment :
    BaseFragment<FragmentTopHeadlinesBinding, TopHeadlinesViewModel>(R.layout.fragment_top_headlines) {

    override val viewModel: TopHeadlinesViewModel by viewModels()
    override val binding by viewBinding(FragmentTopHeadlinesBinding::bind)
    private val newsAdapter = NewsAdapter()

    override fun setupSubscribes() {
        subscribeTopHeadlines()
    }

    override fun initialize() = with(binding.recView) {
        adapter = newsAdapter
    }

    private fun subscribeTopHeadlines() {
        viewModel.fetchTopHeadlines("top-headlines").observe(viewLifecycleOwner) {
            when (it) {
                is Resources.Error -> {
                    Log.e(it.message, "asd")
                }
                is Resources.Loading -> {

                }
                is Resources.Success -> {
                    it.data?.let {
                        newsAdapter.submitList(it.articles)
                    }
                }
            }
        }
    }
}