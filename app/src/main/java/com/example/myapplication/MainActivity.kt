package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.view.PostsAdapter
import com.example.myapplication.viewModel.PostViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: PostsAdapter
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this)[PostViewModel::class.java]

        binding.postRecyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.posts.observe(this) { posts ->
            adapter = PostsAdapter(posts)
            binding.postRecyclerView.adapter = adapter
        }

        viewModel.fetchPosts()
    }
}