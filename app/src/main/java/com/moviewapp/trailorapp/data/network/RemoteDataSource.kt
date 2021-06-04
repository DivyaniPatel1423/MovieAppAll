package com.moviewapp.trailorapp.data.network

import android.content.Context
import androidx.datastore.preferences.protobuf.Api
import androidx.viewbinding.BuildConfig
import okhttp3.Authenticator
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RemoteDataSource @Inject constructor(){

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private const val API_KEY = "2ae0426e62b3cb8455f3631f51db42a7"
       //private const val BASE_URL = "https://api.github.com/"

    }

    fun <Api> buildApi(
        api : Class<Api>,
        context: Context
    ): Api{
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC

        val client = OkHttpClient.Builder()
                .addInterceptor{ chain ->
                    val original = chain.request()
                    val originalHttpUrl = original.url
                    val requestBuilder = original.newBuilder().url(originalHttpUrl.newBuilder().addQueryParameter("api_key", API_KEY).build())
                    chain.proceed(requestBuilder.build())
                }
                .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
                .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

 /*   private fun getRetrofitClient(authenticator: Authenticator? = null): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val originalHttpUrl = original.url
                val requestBuilder = original.newBuilder().url(originalHttpUrl.newBuilder().addQueryParameter("api_key", API_KEY).build())
                chain.proceed(requestBuilder.build())
            }.also { client ->
                authenticator?.let { client.authenticator(it) }
                if (BuildConfig.DEBUG) {
                    val logging = HttpLoggingInterceptor()
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(logging)
                }
            }.build()
    }*/

}