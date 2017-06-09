package com.example.kotlin.movieapp.ui.main

import com.example.kotlin.movieapp.app.App
import com.example.kotlin.movieapp.manager.MovieManager
import com.example.kotlin.movieapp.ui.base.ViewScope
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    @ViewScope
    fun provideMainViewModelFactory(app: App, movieManager: MovieManager) =
            MainViewModel.Factory(app, movieManager)
}
