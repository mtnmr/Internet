package com.example.github.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.github.adapter.GithubListAdapter.*
import com.example.github.databinding.OneItemBinding
import com.example.github.model.Repo

class GithubListAdapter: ListAdapter <Repo, ItemViewHolder> (diffcallback) {

    class ItemViewHolder(private val binding: OneItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item:Repo){
            binding.repoName.text = item.name
            binding.htmlUrl.text = item.htmlUrl
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = OneItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    companion object{
        private val diffcallback = object : DiffUtil.ItemCallback<Repo>(){
            override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
                return  oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}



