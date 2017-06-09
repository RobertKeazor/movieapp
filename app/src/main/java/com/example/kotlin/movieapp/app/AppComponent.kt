package com.example.kotlin.movieapp.app

import com.example.kotlin.movieapp.manager.MovieManager
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = arrayOf(
                AppModule::class,
                DatabaseModule::class,
                ManagerModule::class,
                MapperModule::class,
                NetworkModule::class,
                RepositoryModule::class
        )
)
interface AppComponent {
    fun inject(app: App)

    val app: App

    val movieManager: MovieManager
}
