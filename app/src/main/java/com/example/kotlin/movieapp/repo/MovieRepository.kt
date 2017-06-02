package com.example.kotlin.movieapp.repo

import com.example.kotlin.movieapp.Constants.TMDB_API_V3_KEY
import com.example.kotlin.movieapp.net.MovieService
import com.example.kotlin.movieapp.net.mapper.MovieMapper

class MovieRepository (private val movieService: MovieService, private val movieMapper: MovieMapper) {
    fun topRated(page: Int) = movieService.topRated(TMDB_API_V3_KEY, page)
                .map { movieMapper.transform(it) }
}
