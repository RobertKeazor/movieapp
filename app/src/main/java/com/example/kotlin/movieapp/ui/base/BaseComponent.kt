package com.example.kotlin.movieapp.ui.base

interface BaseComponent<in T> {
    fun inject(view: T)
}
