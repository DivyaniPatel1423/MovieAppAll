package com.moviewapp.trailorapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moviewapp.trailorapp.data.repository.BaseRepository
import com.moviewapp.trailorapp.data.repository.GithubRepository
import com.moviewapp.trailorapp.data.repository.MovieRepository
import com.moviewapp.trailorapp.ui.SearchRepositoriesViewModel
import com.moviewapp.trailorapp.ui.home.MovieViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
        private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(repository as MovieRepository) as T
            modelClass.isAssignableFrom(SearchRepositoriesViewModel::class.java) -> SearchRepositoriesViewModel(repository as GithubRepository) as T
            else -> throw  IllegalArgumentException("ViewModelClass Not Found")
        }
    }
}