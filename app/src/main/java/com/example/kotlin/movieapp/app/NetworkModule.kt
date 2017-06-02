package com.example.kotlin.movieapp.app

import android.content.Context
import com.example.kotlin.movieapp.BuildConfig
import com.example.kotlin.movieapp.Constants.CONNECT_TIMEOUT
import com.example.kotlin.movieapp.Constants.READ_TIMEOUT
import com.example.kotlin.movieapp.Constants.TMDB_API_V3_URL
import com.example.kotlin.movieapp.Constants.WRITE_TIMEOUT
import com.example.kotlin.movieapp.net.MovieService
import com.example.kotlin.movieapp.net.RestClient
import com.example.kotlin.movieapp.net.RestClientConfig
import com.github.ajalt.timberkt.Timber
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BASIC
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule(val context: Context) {
    @Provides
    @Singleton
    fun provideGson() = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .serializeNulls()
            .create()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson) = GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideRxJava2CallAdapterFactory() = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())

    @Provides
    @Singleton
    fun provideHttpLoggingIterceptor() = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { Timber.d {it} })
            .setLevel(if (BuildConfig.DEBUG) BODY else BASIC)

    @Provides
    @Singleton
    fun provideRestClient(
            gsonConverterFactory: GsonConverterFactory,
            rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
            httpLoggingInterceptor: HttpLoggingInterceptor
    ) = RestClient(
            RestClientConfig(
                    debug = BuildConfig.DEBUG,
                    connectTimeoutValue = CONNECT_TIMEOUT,
                    readTimeoutValue = READ_TIMEOUT,
                    writeTimeoutValue = WRITE_TIMEOUT,
                    converterFactories = listOf(gsonConverterFactory),
                    callAdapterFactories = listOf(rxJava2CallAdapterFactory),
                    interceptors = listOf(httpLoggingInterceptor)
            )
    )

    @Provides
    @Singleton
    fun provideMovieService(restClient: RestClient) =
            restClient.createRetrofitAdapter(TMDB_API_V3_URL).create(MovieService::class.java)
}
