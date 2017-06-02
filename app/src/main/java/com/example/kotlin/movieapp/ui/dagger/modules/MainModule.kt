package com.example.kotlin.movieapp.ui.dagger.modules

import com.example.kotlin.movieapp.app.App
import com.example.kotlin.movieapp.ui.main.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    fun provideMainModelViewFactory(app: App): MainViewModel.Factory {
        return MainViewModel.Factory(app)
    }
}
