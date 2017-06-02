package com.example.kotlin.movieapp.net

import com.example.kotlin.movieapp.net.data.MovieResultData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/top_rated")
    fun topRated(@Query("api_key") apiKey: String,
                 @Query("page") page: Int
    ): Single<MovieResultData>
}
