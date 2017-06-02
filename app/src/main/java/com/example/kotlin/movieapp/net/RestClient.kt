package com.example.kotlin.movieapp.net

import com.example.kotlin.movieapp.ext.addCallAdapterFactories
import com.example.kotlin.movieapp.ext.addConverterFactories
import com.example.kotlin.movieapp.ext.addInterceptors
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class RestClient(private val config: RestClientConfig) {
    val okHttpClient = OkHttpClient.Builder()
                .readTimeout(config.readTimeoutValue, config.readTimeoutUnit)
                .writeTimeout(config.writeTimeoutValue, config.writeTimeoutUnit)
                .connectTimeout(config.connectTimeoutValue, config.connectTimeoutUnit)
                .addInterceptors(config.interceptors)
                .build()

    fun createRetrofitAdapter(hostUrl: String) = Retrofit.Builder()
            .baseUrl(hostUrl)
            .validateEagerly(config.debug)
            .client(okHttpClient)
            .addConverterFactories(config.converterFactories)
            .addCallAdapterFactories(config.callAdapterFactories)
            .build()
}
