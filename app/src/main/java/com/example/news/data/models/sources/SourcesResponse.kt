package com.example.news.data.models.sources

import com.google.gson.annotations.SerializedName

data class SourcesResponse<T>(
    @SerializedName("sources")
    val sources: List<T>,
    @SerializedName("status")
    val status: String = ""
)