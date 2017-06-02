package com.example.kotlin.movieapp.app

import android.app.Application

class App : Application() {

    val component by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}
