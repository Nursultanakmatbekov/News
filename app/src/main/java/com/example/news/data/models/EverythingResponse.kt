package com.example.news.data.models

import com.google.gson.annotations.SerializedName

data class EverythingResponse<T>(
    @SerializedName("totalResults")
    val totalResults: Int = 0,
    @SerializedName("articles")
    val articles: List<T>,
    @SerializedName("status")
    val status: String = ""
)