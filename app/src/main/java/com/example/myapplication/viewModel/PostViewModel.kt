package com.example.myapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.PostsItem
import com.example.myapplication.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PostViewModel(application: Application)  : AndroidViewModel(application){

    private val repository = Repository()

    private val _posts = MutableLiveData<List<PostsItem>>()
    val posts : LiveData<List<PostsItem>> = _posts

    var id = -1
    var body : String = ""
    var title : String = ""
    var userId : Int = -1


    suspend fun fetchPosts() {
        withContext(Dispatchers.IO) {
            try {
                repository.getPosts(
                    PostsItem(
                    id = id,
                    body = body,
                    title = title,
                    userId = userId
                )
                )
            } catch (exception : Exception) {
                exception.printStackTrace()
            }
        }
    }
}