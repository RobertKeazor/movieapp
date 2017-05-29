package com.example.kotlin.movieapp.ui.main

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.databinding.ObservableField
import com.example.kotlin.movieapp.ui.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposables
import java.util.concurrent.TimeUnit

class MainViewModel(application: Application) : BaseViewModel(application) {
    val title = "Counter"
    val counter: ObservableField<String> = ObservableField()
    var counterDisposable = Disposables.disposed()

    init {
        counterDisposable = Observable.interval(0, 1, TimeUnit.SECONDS)
                .subscribe({ count -> counter.set(count.toString()) })
    }

    class Factory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>) = MainViewModel(application) as T
    }
}
