package com.example.kotlin.movieapp.navigator

import android.app.Activity
import android.content.Intent
import com.example.kotlin.movieapp.model.Movie
import com.example.kotlin.movieapp.ui.movieInfo.MovieInfoActivity

class Navigator {
    fun showMovieInfoView(activity: Activity, movie: Movie) {
        val intent = Intent(activity, MovieInfoActivity::class.java)
        intent.putExtra("movieExtra", movie)
        activity.startActivity(intent)
    }
}
