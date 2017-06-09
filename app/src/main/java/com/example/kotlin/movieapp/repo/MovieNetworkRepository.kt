package com.example.kotlin.movieapp.repo

import com.example.kotlin.movieapp.Constants.TMDB_API_V3_KEY
import com.example.kotlin.movieapp.net.MovieService
import com.example.kotlin.movieapp.net.mapper.MovieDataMapper

class MovieNetworkRepository(private val movieService: MovieService, private val movieDataMapper: MovieDataMapper) {
    fun topRated(page: Int) = movieService.topRated(TMDB_API_V3_KEY, page)
                .map { movieDataMapper.transform(it) }
}
