package com.example.kotlin.movieapp.ui.main

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.databinding.ObservableArrayList
import com.example.kotlin.movieapp.adapter.ActionHandler
import com.example.kotlin.movieapp.ext.plusAssign
import com.example.kotlin.movieapp.manager.MovieManager
import com.example.kotlin.movieapp.model.Movie
import com.example.kotlin.movieapp.navigator.Navigator
import com.example.kotlin.movieapp.ui.base.BaseViewModel
import com.github.ajalt.timberkt.Timber
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(application: Application, movieManager: MovieManager, val navigator: Navigator) : BaseViewModel(application), ActionHandler {
    private var disposables = CompositeDisposable()
    private var initialized: Boolean = false
    val movies: ObservableArrayList<Movie> = ObservableArrayList()

    init {
        disposables += movieManager.topRated(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetTopRatedSuccess, this::onGetTopRatedError)
    }

    private fun onGetTopRatedSuccess(movies: List<Movie>) {
        if (initialized) {
            //TODO: Notify user that new data is available, for now we immediately display it
            this.movies.addAll(movies)
        } else {
            initialized = true
            if (movies.isEmpty()) {
                //TODO: Brand new state = show loading screen, for now we just show some text
            } else {
                this.movies.addAll(movies)
            }
        }

    }

    private fun onGetTopRatedError(error: Throwable) {
        Timber.d{ error.toString() }
    }

    override fun onMovieClick(movie: Movie) {
        navigator.showMovieInfoView(view, movie)
    }

    override fun onCleared() {
        disposables.dispose()
    }

    class Factory(private val application: Application, private val movieManager: MovieManager, private val  navigator: Navigator) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>) = MainViewModel(application, movieManager, navigator) as T
    }
}
