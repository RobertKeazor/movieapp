package com.example.kotlin.movieapp.app

import android.content.Context
import com.example.kotlin.movieapp.navigator.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigatorModule(val context: Context) {
    @Provides
    @Singleton
    fun provideNavigator() = Navigator()
}
