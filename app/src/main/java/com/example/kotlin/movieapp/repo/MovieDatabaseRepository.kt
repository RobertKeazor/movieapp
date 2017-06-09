package com.example.kotlin.movieapp.repo

import com.example.kotlin.movieapp.db.dao.MovieDao
import com.example.kotlin.movieapp.db.mapper.MovieEntityMapper
import com.example.kotlin.movieapp.model.Movie

class MovieDatabaseRepository(val movieDao: MovieDao, val movieEntityMapper: MovieEntityMapper) {
    fun topRated() = movieDao.topRated()
            .map { movieEntityMapper.transform(it) }

    fun topRatedAsList() = movieDao.topRatedAsList()
            .map { movieEntityMapper.transform(it) }

    fun addMovies(movies: List<Movie>) = movieDao.addMovies(movieEntityMapper.transformMovies(movies))

    fun deleteAll() = movieDao.deleteAll()
}
