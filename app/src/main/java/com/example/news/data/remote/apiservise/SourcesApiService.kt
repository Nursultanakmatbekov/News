package com.example.news.data.remote.apiservise

import com.example.news.data.models.news.EverythingResponse
import com.example.news.data.models.news.News
import com.example.news.data.models.sources.SourcesItem
import com.example.news.data.models.sources.SourcesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SourcesApiService {

    @GET("sources")
    suspend fun fetchSources(
        @Query("q") query: String,
    ): SourcesResponse<SourcesItem>
}