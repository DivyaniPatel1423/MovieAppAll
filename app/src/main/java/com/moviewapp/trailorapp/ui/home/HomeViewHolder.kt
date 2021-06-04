/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.moviewapp.trailorapp.ui.home

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moviewapp.trailorapp.R
import com.moviewapp.trailorapp.data.response.MovieDataResult
import com.moviewapp.trailorapp.data.response.Repo

/**
 * View Holder for a [Repo] RecyclerView list item.
 */
class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val name: TextView = view.findViewById(R.id.content)
    private var repo: Repo? = null


    fun bind(repo: Repo?) {
        if (repo == null) {
            val resources = itemView.resources
            name.text = resources.getString(R.string.loading)

        } else {
            showRepoData(repo)
        }
    }

    private fun showRepoData(repo: Repo) {
        this.repo = repo
        name.text = repo.fullName

    }

    companion object {
        fun create(parent: ViewGroup): HomeViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.raw_item, parent, false)
            return HomeViewHolder(view)
        }
    }
}
