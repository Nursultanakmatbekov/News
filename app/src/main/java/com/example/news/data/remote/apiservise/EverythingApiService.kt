package com.example.news.data.remote.apiservise

import com.example.news.data.models.news.EverythingResponse
import com.example.news.data.models.news.News
import retrofit2.http.GET
import retrofit2.http.Query

interface EverythingApiService {

    @GET("everything")
    suspend fun fetchEverything(
        @Query("q") query: String,
    ): EverythingResponse<News>
}