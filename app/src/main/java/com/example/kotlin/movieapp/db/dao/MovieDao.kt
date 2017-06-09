package com.example.kotlin.movieapp.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.example.kotlin.movieapp.db.entity.MovieEntity
import io.reactivex.Flowable

@Dao
interface MovieDao {
    companion object {
        const val topRatedQuery = "SELECT * FROM " + MovieEntity.NAME + " ORDER BY `order`"
    }

    @Query(topRatedQuery)
    fun topRated(): Flowable<List<MovieEntity>>

    @Query(topRatedQuery)
    fun topRatedAsList(): List<MovieEntity>

    @Insert(onConflict = REPLACE)
    fun addMovies(movies: List<MovieEntity>)

    @Query("DELETE FROM " + MovieEntity.NAME)
    fun deleteAll()
}
