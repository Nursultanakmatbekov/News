package com.example.news.data.repository

import com.example.news.base.BaseRepository
import com.example.news.data.remote.apiservise.EverythingApiService
import com.example.news.data.remote.apiservise.TopHeadlinesApiService
import javax.inject.Inject

class TopHeadlinesRepository @Inject constructor(private val service: TopHeadlinesApiService) :
    BaseRepository() {

    fun fetchHeadlines(q: String) = doRequest {
        service.fetchHeadlines(q)
    }
}