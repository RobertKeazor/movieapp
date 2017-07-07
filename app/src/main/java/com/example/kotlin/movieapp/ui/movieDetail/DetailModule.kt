package com.example.kotlin.movieapp.ui.movieDetail

import com.example.kotlin.movieapp.app.App
import com.example.kotlin.movieapp.manager.MovieManager
import com.example.kotlin.movieapp.ui.base.ViewScope
import dagger.Module
import dagger.Provides

@Module
class DetailModule {
    @Provides
    @ViewScope
    fun provideDetailViewModelFactory(app: App, movieManager: MovieManager) =
            DetailViewModel.Factory(app, movieManager)
}
