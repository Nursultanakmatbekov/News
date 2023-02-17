package com.example.news.ui.fragments.sources

import com.example.news.base.BaseViewModel
import com.example.news.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SourcesViewModel @Inject constructor(private val repository: NewsRepository) :
    BaseViewModel() {

    fun fetchSources(q: String) = repository.fetchNews(q)
}