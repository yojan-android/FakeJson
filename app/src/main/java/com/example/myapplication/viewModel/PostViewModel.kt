package com.example.myapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.PostsItem
import com.example.myapplication.repository.Repository
import kotlinx.coroutines.launch


class PostViewModel(application: Application)  : AndroidViewModel(application){

    private val repository = Repository()

    private val _posts = MutableLiveData<List<PostsItem>>()
    val posts : LiveData<List<PostsItem>> get() =  _posts

     fun fetchPosts() {
       viewModelScope.launch {
            try {
                val postList = repository.getPosts()
                _posts.postValue(postList)
            } catch (exception : Exception) {
                exception.printStackTrace()
            }
        }
    }
}