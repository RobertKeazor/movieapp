package com.example.kotlin.movieapp.adapter

import android.databinding.ObservableList
import com.example.kotlin.movieapp.R
import com.example.kotlin.movieapp.model.Movie

class MovieList(items: ObservableList<Movie>): BaseAdapter<Movie>(items) {
    override fun getLayout(position: Int) = R.layout.item_movie
    override fun getItemForPosition(position: Int) = items[position]
}