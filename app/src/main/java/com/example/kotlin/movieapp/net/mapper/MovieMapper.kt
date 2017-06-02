package com.example.kotlin.movieapp.net.mapper

import com.example.kotlin.movieapp.model.Movie
import com.example.kotlin.movieapp.net.data.MovieData
import com.example.kotlin.movieapp.net.data.MovieResultData

class MovieMapper {
    fun transform(movieData: MovieData) = Movie(
            id = movieData.id,
            name = movieData.title
    )

    fun transform(movieResultData: MovieResultData) = movieResultData.results
            .map { transform(it) }
}
