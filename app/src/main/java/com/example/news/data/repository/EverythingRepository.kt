package com.example.news.data.repository

import com.example.news.base.BaseRepository
import com.example.news.data.remote.apiservise.EverythingApiService
import javax.inject.Inject

class EverythingRepository @Inject constructor(private val service: EverythingApiService) :
    BaseRepository() {

    fun fetchEverything(q: String) = doRequest {
        service.fetchEverything(q)
    }
}