package com.example.news.ui.fragments.everything

import com.example.news.base.BaseViewModel
import com.example.news.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EverythingViewModel @Inject constructor(private val repository: NewsRepository) :
    BaseViewModel() {

    fun fetchEverything(q:String) = repository.fetchNews(q)
}