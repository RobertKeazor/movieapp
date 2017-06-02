package com.example.kotlin.movieapp.ui.main

import com.example.kotlin.movieapp.app.App
import com.example.kotlin.movieapp.repo.MovieRepository
import com.example.kotlin.movieapp.ui.base.ViewScope
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    @ViewScope
    fun provideMainViewModelFactory(app: App, movieRepository: MovieRepository) =
            MainViewModel.Factory(app, movieRepository)
}
