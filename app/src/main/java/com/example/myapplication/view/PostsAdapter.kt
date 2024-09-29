package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.PostsItem

class PostsAdapter(private val postsItem: List<PostsItem>) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {
    inner class PostViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val title : TextView = itemView.findViewById(R.id.textViewTitle)
        private val body : TextView = itemView.findViewById(R.id.textViewBody)

        fun bind(post : PostsItem) {
            title.text = post.title
            body.text = post.body
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent , false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postsItem[position])
    }

    override fun getItemCount(): Int {
       return postsItem.size
    }

}