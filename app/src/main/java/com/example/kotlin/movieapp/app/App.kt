package com.example.kotlin.movieapp.app

import android.app.Application

class App : Application() {

    companion object {
        @JvmStatic
        lateinit var get: App

        @JvmStatic
        val modules: AppModule = AppModule.INSTANCE
    }

    override fun onCreate() {
        get = this
        super.onCreate()
    }
}
