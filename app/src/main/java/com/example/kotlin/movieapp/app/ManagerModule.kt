package com.example.kotlin.movieapp.app

import android.content.Context
import com.example.kotlin.movieapp.manager.MovieManager
import com.example.kotlin.movieapp.repo.MovieDatabaseRepository
import com.example.kotlin.movieapp.repo.MovieNetworkRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ManagerModule(val context: Context) {
    @Provides
    @Singleton
    fun provideMovieManager(movieDatabaseRepository: MovieDatabaseRepository, movieNetworkRepository: MovieNetworkRepository) =
            MovieManager(movieDatabaseRepository, movieNetworkRepository)
}
