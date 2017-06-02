package com.example.kotlin.movieapp.app

import android.content.Context
import com.example.kotlin.movieapp.net.mapper.MovieMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MapperModule(val context: Context) {
    @Provides
    @Singleton
    fun provideMovieMapper() = MovieMapper()
}
