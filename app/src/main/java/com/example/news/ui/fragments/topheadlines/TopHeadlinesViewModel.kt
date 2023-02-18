package com.example.news.ui.fragments.topheadlines

import com.example.news.base.BaseViewModel
import com.example.news.data.repository.EverythingRepository
import com.example.news.data.repository.TopHeadlinesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopHeadlinesViewModel @Inject constructor(private val repository: TopHeadlinesRepository) :
    BaseViewModel() {

    fun fetchTopHeadlines(q: String) = repository.fetchHeadlines(q)
}