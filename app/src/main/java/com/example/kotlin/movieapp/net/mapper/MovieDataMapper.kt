package com.example.kotlin.movieapp.net.mapper

import com.example.kotlin.movieapp.model.Movie
import com.example.kotlin.movieapp.net.data.MovieData
import com.example.kotlin.movieapp.net.data.MovieResultData

class MovieDataMapper {
    fun transform(movieData: MovieData) = Movie(
            id = movieData.id,
            name = movieData.title,
            posterPath = "https://image.tmdb.org/t/p/w500/${movieData.posterPath}" //TODO get this from preferences after loading configuration
    )

    fun transform(movieResultData: MovieResultData) = movieResultData.results
            .map { transform(it) }
}
