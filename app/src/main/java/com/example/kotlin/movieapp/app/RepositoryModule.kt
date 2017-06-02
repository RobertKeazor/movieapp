package com.example.kotlin.movieapp.app

import android.content.Context
import com.example.kotlin.movieapp.net.MovieService
import com.example.kotlin.movieapp.net.mapper.MovieMapper
import com.example.kotlin.movieapp.repo.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule(val context: Context) {
    @Provides
    @Singleton
    fun provideMovieRepository(movieService: MovieService, movieMapper: MovieMapper) =
            MovieRepository(movieService, movieMapper)
}
