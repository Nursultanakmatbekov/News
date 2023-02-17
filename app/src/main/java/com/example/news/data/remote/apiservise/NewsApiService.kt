package com.example.news.data.remote.apiservise

import com.example.news.data.models.EverythingResponse
import com.example.news.data.models.News
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("everything")
    suspend fun fetchEverything(
        @Query("q") query: String,
    ): EverythingResponse<News>
}