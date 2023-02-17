package com.example.news.ui.fragments.sources

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.news.R
import com.example.news.base.BaseFragment
import com.example.news.databinding.FragmentSourcesBinding
import com.example.news.ui.adapter.NewsAdapter
import com.example.news.utils.Resources
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SourcesFragment :
    BaseFragment<FragmentSourcesBinding, SourcesViewModel>(R.layout.fragment_sources) {

    override val viewModel: SourcesViewModel by viewModels()
    override val binding by viewBinding(FragmentSourcesBinding::bind)
    private val sourcesAdapter = NewsAdapter()

    override fun setupSubscribes() {
        subscribeToEverything()
    }

    override fun initialize() = with(binding.recView) {
        adapter = sourcesAdapter
    }

    private fun subscribeToEverything() {
        viewModel.fetchSources("sources").observe(viewLifecycleOwner) {
            when (it) {
                is Resources.Error -> {
                    Log.e(it.message, "asd")
                }
                is Resources.Loading -> {

                }
                is Resources.Success -> {
                    it.data?.let {
                        sourcesAdapter.submitList(it.articles)
                    }
                }
            }
        }
    }
}