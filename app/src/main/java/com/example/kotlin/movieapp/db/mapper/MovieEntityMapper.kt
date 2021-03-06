package com.example.kotlin.movieapp.db.mapper

import com.example.kotlin.movieapp.db.entity.MovieEntity
import com.example.kotlin.movieapp.model.Movie

class MovieEntityMapper {
    fun transform(movies: List<MovieEntity>) = movies
            .map { transform(it)}

    fun transform(movieEntity: MovieEntity) = Movie(
            id = movieEntity.id,
            name = movieEntity.title,
            posterPath = movieEntity.posterPath
    )

    fun transformMovies(movies: List<Movie>) = movies
            .mapIndexed { index, movie -> transformMovie(index, movie) }

    fun transformMovie(order: Int, movie: Movie) = MovieEntity(
            posterPath = movie.posterPath,
            adult = false,
            overview = "",
            releaseDate = "",
            id = movie.id,
            originalTitle = "",
            originalLanguage = "",
            title = movie.name,
            backdropPath = "",
            popularity = 0.0,
            voteCount = 0,
            video = false,
            voteAverage = 0.0,
            order = order
    )
}
