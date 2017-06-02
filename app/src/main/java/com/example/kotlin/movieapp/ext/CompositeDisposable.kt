package com.example.kotlin.movieapp.ext

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

operator fun CompositeDisposable.plusAssign(disposable: Disposable): Unit {
    this.add(disposable)
}
