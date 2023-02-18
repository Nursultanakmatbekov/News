package com.example.news.data.remote.apiservise

import com.example.news.data.models.news.EverythingResponse
import com.example.news.data.models.news.News
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlinesApiService {

    @GET("top-headlines")
    suspend fun fetchHeadlines(
        @Query("q") query: String,
    ): EverythingResponse<News>
}