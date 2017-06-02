package com.example.kotlin.movieapp.app

import com.example.kotlin.movieapp.repo.MovieRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = arrayOf(
                AppModule::class,
                MapperModule::class,
                NetworkModule::class,
                RepositoryModule::class
        )
)
interface AppComponent {
    fun inject(app: App)

    fun getApp(): App

    fun getMovieRepository(): MovieRepository
}
