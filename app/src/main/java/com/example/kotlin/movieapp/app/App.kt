package com.example.kotlin.movieapp.app

import android.app.Application
import com.example.kotlin.movieapp.BuildConfig
import timber.log.Timber

class App : Application() {
    val component by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .databaseModule(DatabaseModule(this))
                .managerModule(ManagerModule(this))
                .mapperModule(MapperModule(this))
                .networkModule(NetworkModule(this))
                .repositoryModule(RepositoryModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)

        setupLogging()
        instance = this
    }

    private fun setupLogging() {
        Timber.uprootAll()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        lateinit var instance: App
            private set
    }
}
