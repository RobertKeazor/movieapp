package com.example.kotlin.movieapp.manager

import com.example.kotlin.movieapp.repo.MovieDatabaseRepository
import com.example.kotlin.movieapp.repo.MovieNetworkRepository
import io.reactivex.Flowable

class MovieManager(val movieDatabaseRepository: MovieDatabaseRepository, val movieNetworkRepository: MovieNetworkRepository) {
    fun topRated(page: Int) = Flowable.merge (
            movieDatabaseRepository.topRated(),
            movieNetworkRepository.topRated(page)
                    .filter {
                        if (it != movieDatabaseRepository.topRatedAsList()) {
                            movieDatabaseRepository.deleteAll()
                            movieDatabaseRepository.addMovies(it)
                        }
                        false
                    }
    )
}
