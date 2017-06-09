package com.example.kotlin.movieapp.app

import android.arch.persistence.room.Room
import android.content.Context
import com.example.kotlin.movieapp.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(val context: Context) {
    @Provides
    @Singleton
    fun provideAppDatabase(): AppDatabase =
            Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    AppDatabase.NAME
            ).build()

    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: AppDatabase) = appDatabase.movieDao()
}
