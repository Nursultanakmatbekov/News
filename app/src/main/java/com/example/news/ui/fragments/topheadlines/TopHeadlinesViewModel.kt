package com.example.news.ui.fragments.topheadlines

import com.example.news.base.BaseViewModel
import com.example.news.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopHeadlinesViewModel @Inject constructor(private val repository: NewsRepository) :
    BaseViewModel() {

    fun fetchTopHeadlines(q: String) = repository.fetchNews(q)
}