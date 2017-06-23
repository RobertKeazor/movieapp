package com.example.kotlin.movieapp.adapter

import android.databinding.ObservableArrayList
import com.example.kotlin.movieapp.R
import com.example.kotlin.movieapp.model.Movie

class MovieAdapter(items: ObservableArrayList<Movie>, override val handler: ActionHandler?): BaseAdapter<Movie, ActionHandler?>(items) {
    override fun getLayout(position: Int) = R.layout.item_movie
}

interface ActionHandler {
    fun onMovieClick(movie: Movie)
}
