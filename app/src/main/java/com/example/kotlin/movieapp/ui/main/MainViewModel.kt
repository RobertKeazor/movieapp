package com.example.kotlin.movieapp.ui.main

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.databinding.ObservableField
import com.example.kotlin.movieapp.ext.plusAssign
import com.example.kotlin.movieapp.model.Movie
import com.example.kotlin.movieapp.repo.MovieRepository
import com.example.kotlin.movieapp.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(application: Application, movieRepository: MovieRepository) : BaseViewModel(application) {
    val title = "Movies"
    val data: ObservableField<String> = ObservableField()
    var disposables = CompositeDisposable()

    init {
        disposables += movieRepository.topRated(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetTopRatedSuccess, this::onGetTopRatedError)
    }

    private fun onGetTopRatedSuccess(movies: List<Movie>) {
        data.set(
                StringBuilder().apply {
                    movies.forEach {
                        append("${it.id} - ${it.name}")
                        append(System.lineSeparator())
                    }
                }.toString()
        )
    }

    private fun onGetTopRatedError(error: Throwable) {
        data.set(error.toString())
    }

    override fun onCleared() {
        disposables.dispose()
    }

    class Factory(private val application: Application, private val movieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>) = MainViewModel(application, movieRepository) as T
    }
}
