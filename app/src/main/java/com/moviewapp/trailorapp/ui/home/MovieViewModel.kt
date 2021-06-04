package com.moviewapp.trailorapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moviewapp.trailorapp.data.network.Resource
import com.moviewapp.trailorapp.data.repository.MovieRepository
import com.moviewapp.trailorapp.data.response.MovieDataRepsonse
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class MovieViewModel @Inject constructor(
        private val repository: MovieRepository
) : ViewModel(){

    private val _allMovieList : MutableLiveData<Resource<MovieDataRepsonse>> = MutableLiveData()
    val allMovieList : LiveData<Resource<MovieDataRepsonse>>?
        get() = _allMovieList

    fun getAllMovie(
            page : Int
    )=viewModelScope.launch {
        _allMovieList.value = repository.movieApi(page)
    }
}