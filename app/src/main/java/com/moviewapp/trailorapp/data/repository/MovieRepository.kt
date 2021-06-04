package com.moviewapp.trailorapp.data.repository

import com.moviewapp.trailorapp.data.network.MovieApi
import javax.inject.Inject

private const val STARTING_PAGE_INDEX = 1
class MovieRepository @Inject constructor(
    private val api : MovieApi
): BaseRepository(api) {

    suspend fun movieApi(
            page: Int
    ) = safeApiCall{
        api.movieApi(page)
    }
}