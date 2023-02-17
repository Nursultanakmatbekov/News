package com.example.news.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("apiKey", "4dd89c8c1486430c81a64751e4545656").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}