package com.example.kotlin.movieapp.binding

import android.databinding.BindingAdapter
import android.databinding.ObservableArrayList
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.kotlin.movieapp.adapter.ActionHandler
import com.example.kotlin.movieapp.adapter.MovieAdapter
import com.example.kotlin.movieapp.model.Movie

object RecyclerViewBinding {
    @JvmStatic
    @BindingAdapter(value = *arrayOf("items", "handler"), requireAll = false)
    fun setItems(recyclerView: RecyclerView, items: ObservableArrayList<Movie>?, handler: ActionHandler?) {
        if (items != null) {
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.adapter = MovieAdapter(items, handler)
        }
    }
}
