package com.example.myapplication.repository

import com.example.myapplication.model.PostsItem
import com.example.myapplication.networking.RetrofitInstance
import retrofit2.Response


class Repository {
    suspend fun getPosts() : List<PostsItem>{
        return RetrofitInstance.apiService.getPosts()
    }
}