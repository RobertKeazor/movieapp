package com.example.kotlin.movieapp.ext

import retrofit2.CallAdapter
import retrofit2.Retrofit

fun Retrofit.Builder.addCallAdapterFactories(factories: List<CallAdapter.Factory>): Retrofit.Builder {
    factories.forEach { this.addCallAdapterFactory(it) }
    return this
}
