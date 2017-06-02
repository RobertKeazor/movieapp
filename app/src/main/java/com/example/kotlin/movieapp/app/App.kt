package com.example.kotlin.movieapp.app

import android.app.Application

class App : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    companion object {
        @JvmStatic
        lateinit var get: App
    }


    override fun onCreate() {
        get = this
        super.onCreate()
        component.inject(this)

    }
}

