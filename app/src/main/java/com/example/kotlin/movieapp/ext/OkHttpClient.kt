package com.example.kotlin.movieapp.ext

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

fun OkHttpClient.Builder.addInterceptors(interceptors: List<Interceptor>): OkHttpClient.Builder {
    interceptors.forEach { this.addInterceptor(it) }
    return this
}

fun Retrofit.Builder.addConverterFactories(factories: List<Converter.Factory>): Retrofit.Builder {
    factories.forEach { this.addConverterFactory(it) }
    return this
}
