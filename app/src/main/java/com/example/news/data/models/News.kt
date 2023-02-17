package com.example.news.data.models

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("publishedAt")
    val publishedAt: String = "",
    @SerializedName("author")
    val author: String = "",
    @SerializedName("urlToImage")
    val urlToImage: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("content")
    val content: String = ""
)