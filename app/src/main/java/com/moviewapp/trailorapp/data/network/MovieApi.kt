package com.moviewapp.trailorapp.data.network

import com.moviewapp.trailorapp.data.response.MovieDataRepsonse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi : BaseApi{

    @GET("movie/popular")
    suspend fun movieApi(
        @Query("page") page : Int
    ) : MovieDataRepsonse
    
}