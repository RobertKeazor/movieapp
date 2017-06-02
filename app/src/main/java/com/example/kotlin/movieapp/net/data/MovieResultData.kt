package com.example.kotlin.movieapp.net.data

data class MovieResultData (
        var page: Int,
        var results: List<MovieData>,
        var totalResults: Int,
        var totalPages: Int
)
