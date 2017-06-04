package com.example.kotlin.movieapp.repo

import com.example.kotlin.movieapp.fakes.Fakers
import com.example.kotlin.movieapp.model.Movie
import com.example.kotlin.movieapp.net.MovieService
import com.example.kotlin.movieapp.net.mapper.MovieMapper
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Single
import io.reactivex.subscribers.TestSubscriber
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString

@RunWith(JUnitPlatform::class)
internal class MovieRepositoryTest : Spek({

    var movieResultData = Fakers.generateMovieResultData()
    var movie = Fakers.generateMovie()
    var movieList = listOf(movie)
    val movieService = mock<MovieService> {
        on {topRated(anyString(), anyInt())} doReturn Single.just(movieResultData)
    }
    val movieMapper = mock<MovieMapper> {
        on {transform(movieResultData)} doReturn movieList
    }

    val movieRepository = MovieRepository(movieService, movieMapper)
    val subscriber = TestSubscriber<List<Movie>>()

    describe("retreving top rated movies") {

        given("the following top rated subscription") {
                movieRepository
                        .topRated(5)
                        .toFlowable() //LessonLearned: TestSubscriber needs a observable or flowable
                        .subscribe(subscriber)
            }

            it("should have the following values") {
                subscriber.apply {
                    awaitTerminalEvent()
                    assertNoErrors()
                    assertValueCount(1)
                    assertValue(movieList)
                }
            }
    }


})