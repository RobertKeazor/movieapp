package com.example.kotlin.movieapp.fakes

import com.example.kotlin.movieapp.model.Movie
import com.example.kotlin.movieapp.net.data.MovieData
import com.example.kotlin.movieapp.net.data.MovieResultData

object Fakers {
    fun generateMovieResultData(pageFake: Int = Math.random().toInt(),
                                resultsFake: List<MovieData> = listOf(generateMovieData()),
                                totalResultsFake: Int = Math.random().toInt(),
                                totalPagesFake: Int = Math.random().toInt()) =
            MovieResultData(
                    page = pageFake,
                    results = resultsFake,
                    totalPages = totalPagesFake,
                    totalResults = totalResultsFake)

    fun generateMovieData(posterPathFake: String? = "Hello Test",
                          adultFake: Boolean = false,
                          overviewFake: String = "Hello Test",
                          releaseDataFake: String = "Hello Test",
                          generIdsFake: List<Int> = listOf(5),
                          idFaker: Int = Math.random().toInt(),
                          originalTitleFake: String = "Hello Test",
                          originalLanguageFake: String = "Hello Test",
                          titleFake: String = "Hello Test",
                          backdropPathFake: String? = "Hello Test",
                          popularityFake: Int = Math.random().toInt(),
                          voteCountFake: Int = Math.random().toInt(),
                          videoFake: Boolean = false,
                          voteAverageFake: Number = Math.random()) =
            MovieData(
                    posterPath = posterPathFake,
                    adult = adultFake,
                    overview = overviewFake,
                    releaseDate = releaseDataFake,
                    genreIds = generIdsFake,
                    id = idFaker,
                    originalTitle = originalTitleFake,
                    originalLanguage = originalLanguageFake,
                    title = titleFake,
                    backdropPath = backdropPathFake,
                    popularity = popularityFake,
                    voteCount = voteCountFake,
                    video = videoFake,
                    voteAverage = voteAverageFake)

    fun generateMovie(idFake: Int = 90210, nameFake: String = "Mr Test") =
            Movie(id = idFake, name = nameFake)
}

