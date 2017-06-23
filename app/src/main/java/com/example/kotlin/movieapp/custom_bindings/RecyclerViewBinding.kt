package com.example.kotlin.movieapp.custom_bindings

import android.databinding.BindingAdapter
import android.databinding.ObservableArrayList
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.kotlin.movieapp.adapter.MovieList
import com.example.kotlin.movieapp.model.Movie

object RecyclerViewBinding {
    @JvmStatic
    @BindingAdapter("items")
    fun setupItems(recyclerView: RecyclerView, items: ObservableArrayList<Movie>) {
        var adapter = MovieList(items)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = adapter
    }
}
