package com.moviewapp.trailorapp.di

import android.content.Context
import com.moviewapp.trailorapp.data.network.MovieApi
import com.moviewapp.trailorapp.data.network.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMovieApi(
        remoteDataSource: RemoteDataSource,
        @ApplicationContext context: Context
    ): MovieApi {
        return remoteDataSource.buildApi(MovieApi::class.java, context)
    }

}