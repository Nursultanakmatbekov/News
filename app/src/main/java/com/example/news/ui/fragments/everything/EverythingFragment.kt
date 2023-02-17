package com.example.news.ui.fragments.everything

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.news.R
import com.example.news.base.BaseFragment
import com.example.news.databinding.FragmentEverythingBinding
import com.example.news.ui.adapter.NewsAdapter
import com.example.news.utils.Resources
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EverythingFragment :
    BaseFragment<FragmentEverythingBinding, EverythingViewModel>(R.layout.fragment_everything) {

    override val viewModel: EverythingViewModel by viewModels()
    override val binding by viewBinding(FragmentEverythingBinding::bind)
    private val everythingAdapter = NewsAdapter()

    override fun setupSubscribes() {
        subscribeToEverything()
    }

    override fun initialize() = with(binding.recView) {
        adapter = everythingAdapter
    }

    private fun subscribeToEverything() {
        viewModel.fetchEverything("bitcoin").observe(viewLifecycleOwner) {
            when (it) {
                is Resources.Error -> {
                    Log.e(it.message, "asd")
                }
                is Resources.Loading -> {

                }
                is Resources.Success -> {
                    it.data?.let {
                        everythingAdapter.submitList(it.articles)
                    }
                }
            }
        }
    }
}