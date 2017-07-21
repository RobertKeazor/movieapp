package com.example.kotlin.movieapp.ui.movieInfo

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.kotlin.movieapp.adapter.ActionHandler
import com.example.kotlin.movieapp.manager.MovieManager
import com.example.kotlin.movieapp.model.Movie
import com.example.kotlin.movieapp.navigator.Navigator
import com.example.kotlin.movieapp.ui.base.BaseViewModel
import kotlin.properties.Delegates

class MovieInfoViewModel(application: Application, navigator: Navigator, movieManager: MovieManager) : BaseViewModel(application), ActionHandler {
    var movie :  Movie by Delegates.notNull()

    override fun onMovieClick(movie: Movie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class Factory(private val application: Application, private val navigator: Navigator, private val movieManager: MovieManager) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>) = MovieInfoViewModel(application, navigator, movieManager) as T
    }
}