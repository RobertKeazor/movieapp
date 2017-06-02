package com.example.kotlin.movieapp.app

import com.example.kotlin.movieapp.ui.main.MainComponent
import com.example.kotlin.movieapp.ui.main.MainModule
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

    fun plus(mainModule: MainModule): MainComponent
}
