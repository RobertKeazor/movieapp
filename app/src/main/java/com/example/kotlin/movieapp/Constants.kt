package com.example.kotlin.movieapp

object Constants {
    const private val TMDB_API_BASE_URL = "https://api.themoviedb.org"
    const val TMDB_API_V3_URL = TMDB_API_BASE_URL + "/3/"
    const val TMDB_API_V4_URL = TMDB_API_BASE_URL + "/4/"
    const val TMDB_API_V3_KEY = "587096638a8d8dd02c82918ec6116a82"
    const val TMDB_API_V4_KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1ODcwOTY2MzhhOGQ4ZGQwMmM4MjkxOGVjNjExNmE4MiIsInN1YiI6IjU5MmYzMTIxYzNhMzY4MmM0YzAwMDM2MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.uhRHUhqmo65t52JwyUqXr9lXoWLSX5efHgNO61dU02E"

    const val READ_TIMEOUT = 20L
    const val WRITE_TIMEOUT = 20L
    const val CONNECT_TIMEOUT = 20L
}
