package com.example.news.data.repository

import com.example.news.base.BaseRepository
import com.example.news.data.remote.apiservise.EverythingApiService
import com.example.news.data.remote.apiservise.SourcesApiService
import javax.inject.Inject

class SourcesRepository @Inject constructor(private val service: SourcesApiService) :
    BaseRepository() {

    fun fetchSources(q: String) = doRequest {
        service.fetchSources(q)
    }
}