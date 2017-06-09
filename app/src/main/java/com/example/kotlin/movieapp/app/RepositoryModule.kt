package com.example.kotlin.movieapp.app

import android.content.Context
import com.example.kotlin.movieapp.db.dao.MovieDao
import com.example.kotlin.movieapp.db.mapper.MovieEntityMapper
import com.example.kotlin.movieapp.net.MovieService
import com.example.kotlin.movieapp.net.mapper.MovieDataMapper
import com.example.kotlin.movieapp.repo.MovieDatabaseRepository
import com.example.kotlin.movieapp.repo.MovieNetworkRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule(val context: Context) {
    @Provides
    @Singleton
    fun provideMovieDatabaseRepository(movieDao: MovieDao, movieEntityMapper: MovieEntityMapper) =
            MovieDatabaseRepository(movieDao, movieEntityMapper)

    @Provides
    @Singleton
    fun provideMovieNetworkRepository(movieService: MovieService, movieDataMapper: MovieDataMapper) =
            MovieNetworkRepository(movieService, movieDataMapper)
}
