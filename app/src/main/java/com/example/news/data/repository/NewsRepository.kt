package com.example.news.data.repository

import com.example.news.base.BaseRepository
import com.example.news.data.remote.apiservise.NewsApiService
import javax.inject.Inject

class NewsRepository @Inject constructor(private val service: NewsApiService) :
    BaseRepository() {

    fun fetchNews(q: String) = doRequest {
        service.fetchEverything(q)
    }
}