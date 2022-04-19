package com.example.github.adapter


import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.github.R
import com.example.github.model.Repo
import com.example.github.viewmodel.ApiStatus

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("listData")
    fun bindRecyclerView(recyclerView: RecyclerView, data : List<Repo>?) {
        val adapter = recyclerView.adapter as GithubListAdapter
        adapter.submitList(data)
    }

    @JvmStatic
    @BindingAdapter("ApiStatus")
    fun bindStatus(statusText:TextView, status : ApiStatus?){
        when(status){
            ApiStatus.DONE ->{
                statusText.visibility = View.GONE
            }
            ApiStatus.LOADING ->{
                statusText.visibility = View.VISIBLE
                statusText.setText(R.string.loading_message)
            }
            ApiStatus.ERROR ->{
                statusText.visibility = View.VISIBLE
                statusText.setText(R.string.error_message)
            }
        }
    }
}