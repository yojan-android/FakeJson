package com.example.myapplication.repository

import com.example.myapplication.model.PostsItem
import com.example.myapplication.networking.RetrofitInstance

class Repository {
    suspend fun getPosts(postsItem: PostsItem) {
        try {
            RetrofitInstance.apiService.getPosts()
        } catch (exception : Exception) {
            exception.stackTrace
        }
    }
}