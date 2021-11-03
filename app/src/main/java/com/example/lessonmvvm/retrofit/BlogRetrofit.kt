package com.example.lessonmvvm.retrofit

import retrofit2.http.GET

interface BlogRetrofit {
    @GET("blogs")
    suspend fun fetchBlogs(): List<BlogNetworkEntity>
}