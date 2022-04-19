package com.example.github.adapter


import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.github.model.Repo

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("listData")
    fun bindRecyclerView(recyclerView: RecyclerView, data : List<Repo>?) {
        val adapter = recyclerView.adapter as GithubListAdapter
        adapter.submitList(data)
    }
}