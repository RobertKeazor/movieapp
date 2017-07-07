package com.example.kotlin.movieapp.app

import com.example.kotlin.movieapp.manager.MovieManager
import com.example.kotlin.movieapp.nav.Navigator
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
                NavigatorModule::class,
                RepositoryModule::class
        )
)
interface AppComponent {
    fun inject(app: App)

    val app: App

    val movieManager: MovieManager

    val navigator: Navigator
}
