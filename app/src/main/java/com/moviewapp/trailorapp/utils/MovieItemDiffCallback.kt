package com.moviewapp.trailorapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.moviewapp.trailorapp.data.response.MovieDataResult

/**
 * Created by Divyani patel
 *
 */
object MovieItemDiffCallback {
    val diffCallback = object : DiffUtil.ItemCallback<MovieDataResult>() {
        override fun areItemsTheSame(oldItem: MovieDataResult, newItem: MovieDataResult): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: MovieDataResult, newItem: MovieDataResult): Boolean = oldItem == newItem
    }
}