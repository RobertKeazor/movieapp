package com.example.kotlin.movieapp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.kotlin.movieapp.db.dao.MovieDao
import com.example.kotlin.movieapp.db.entity.MovieEntity

@Database(
        entities = arrayOf(MovieEntity::class),
        version = 1
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val NAME = "appDatabase"
    }

    abstract fun movieDao(): MovieDao
}
