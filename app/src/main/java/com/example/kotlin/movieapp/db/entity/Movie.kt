package com.example.kotlin.movieapp.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.kotlin.movieapp.db.entity.MovieEntity.Companion.NAME

@Entity(tableName = NAME)
data class MovieEntity(
        var posterPath: String?,
        var adult: Boolean,
        var overview: String,
        var releaseDate: String,
        @PrimaryKey
        var id: Int,
        var originalTitle: String,
        var originalLanguage: String,
        var title: String,
        var backdropPath: String?,
        var popularity: Double,
        var voteCount: Int,
        var video: Boolean,
        var voteAverage: Double,
        var order: Int
) {
        companion object {
                const val NAME = "movie"
        }
}
