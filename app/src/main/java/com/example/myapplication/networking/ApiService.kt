package com.example.myapplication.networking

import com.example.myapplication.model.PostsItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    suspend fun getPosts() : List<PostsItem>
}