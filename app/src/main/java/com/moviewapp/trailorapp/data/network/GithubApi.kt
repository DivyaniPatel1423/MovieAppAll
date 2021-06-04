package com.moviewapp.trailorapp.data.network

import com.moviewapp.trailorapp.data.response.RepoSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi :BaseApi {
    /**
     * Get repos ordered by stars.
     */
    @GET("search/repositories?sort=stars")
    suspend fun searchRepos(
            @Query("q") query: String,
            @Query("page") page: Int,
            @Query("per_page") itemsPerPage: Int
    ): RepoSearchResponse

}