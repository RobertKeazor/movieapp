package com.example.kotlin.movieapp.net

import okhttp3.Interceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import java.util.concurrent.TimeUnit

data class RestClientConfig (
        val readTimeoutValue: Long,
        val readTimeoutUnit: TimeUnit = TimeUnit.SECONDS,
        val writeTimeoutValue: Long,
        val writeTimeoutUnit: TimeUnit = TimeUnit.SECONDS,
        val connectTimeoutValue: Long,
        val connectTimeoutUnit: TimeUnit = TimeUnit.SECONDS,
        val converterFactories: List<Converter.Factory>,
        val callAdapterFactories: List<CallAdapter.Factory>,
        val interceptors: List<Interceptor>,
        val debug: Boolean
)
