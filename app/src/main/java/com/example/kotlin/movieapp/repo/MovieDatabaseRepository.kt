package com.example.kotlin.movieapp.repo

import com.example.kotlin.movieapp.db.dao.MovieDao
import com.example.kotlin.movieapp.db.mapper.MovieEntityMapper
import com.example.kotlin.movieapp.model.Movie
import io.reactivex.schedulers.Schedulers

class MovieDatabaseRepository(val movieDao: MovieDao, val movieEntityMapper: MovieEntityMapper) {
    fun topRated() = movieDao.topRated()
            .subscribeOn(Schedulers.io())
            .map { movieEntityMapper.transform(it) }

    fun topRatedAsList() = movieDao.topRatedAsList()
            .map { movieEntityMapper.transform(it) }

    fun addMovies(movies: List<Movie>) = movieDao.addMovies(movieEntityMapper.transformMovies(movies))

    fun deleteAll() = movieDao.deleteAll()
}
