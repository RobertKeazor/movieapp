package com.example.kotlin.movieapp.app

import com.example.kotlin.movieapp.ui.dagger.components.MainComponent
import com.example.kotlin.movieapp.ui.dagger.modules.MainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)

    fun plus(mainModule: MainModule): MainComponent
}
