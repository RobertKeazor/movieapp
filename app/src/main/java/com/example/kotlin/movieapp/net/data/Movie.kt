package com.example.kotlin.movieapp.net.data

data class MovieResultData (
        var page: Int,
        var results: List<MovieData>,
        var totalResults: Int,
        var totalPages: Int
)

data class MovieData (
        var posterPath: String?,
        var adult: Boolean,
        var overview: String,
        var releaseDate: String,
        var genreIds: List<Int>,
        var id: Int,
        var originalTitle: String,
        var originalLanguage: String,
        var title: String,
        var backdropPath: String?,
        var popularity: Number,
        var voteCount: Int,
        var video: Boolean,
        var voteAverage: Number
)
