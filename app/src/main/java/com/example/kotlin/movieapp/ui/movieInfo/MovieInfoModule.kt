package com.example.kotlin.movieapp.ui.movieInfo

import com.example.kotlin.movieapp.app.App
import com.example.kotlin.movieapp.manager.MovieManager
import com.example.kotlin.movieapp.navigator.Navigator
import com.example.kotlin.movieapp.ui.base.ViewScope
import dagger.Module
import dagger.Provides

@Module
class MovieInfoModule {
    @Provides
    @ViewScope
    fun provideMovieInfoViewModelFactory(app: App, navigator: Navigator, movieManager: MovieManager) =
        MovieInfoViewModel.Factory(app, navigator, movieManager)

}