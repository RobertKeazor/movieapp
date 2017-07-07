package com.example.kotlin.movieapp.ui.movieDetail

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.databinding.ObservableField
import com.example.kotlin.movieapp.manager.MovieManager
import com.example.kotlin.movieapp.model.Movie
import com.example.kotlin.movieapp.ui.base.BaseViewModel


class DetailViewModel(application: Application, movieManager: MovieManager) : BaseViewModel(application) {
    var simpleText: ObservableField<String> = ObservableField()

    fun  initalize(movie: Movie) {
        simpleText.set(movie.name)
    }

    class Factory(private val application: Application, private val movieManager: MovieManager) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>) = DetailViewModel(application, movieManager) as T
    }


}
