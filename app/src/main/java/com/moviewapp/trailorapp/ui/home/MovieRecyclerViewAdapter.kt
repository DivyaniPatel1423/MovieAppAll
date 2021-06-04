package com.moviewapp.trailorapp.ui.home

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.moviewapp.trailorapp.R
import com.moviewapp.trailorapp.data.response.MovieDataResult
import com.moviewapp.trailorapp.databinding.RawItemBinding


class MyItemRecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    private var listMovie :List<MovieDataResult> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: RawItemBinding = RawItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listMovie[position]
        holder.textView.text = item.original_title
    }

    override fun getItemCount(): Int = listMovie.size

    fun moviewList(movies: List<MovieDataResult>) {
        listMovie = movies
        notifyDataSetChanged()
    }
     class ViewHolder(binding: RawItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val textView = binding.content

    }
}