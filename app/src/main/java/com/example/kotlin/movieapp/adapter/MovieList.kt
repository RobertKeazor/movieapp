package com.example.kotlin.movieapp.adapter

import com.example.kotlin.movieapp.R
import com.example.kotlin.movieapp.model.Movie


class MovieList(items: List<Movie>): BaseAdapter<Movie>(items) {
    override fun getLayout() = R.layout.item_movie

    override fun getItemForPosition(position: Int) = items[position]
}