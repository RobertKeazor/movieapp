package com.example.kotlin.movieapp.nav

import android.content.Context
import android.content.Intent
import com.example.kotlin.movieapp.ui.movieDetail.DetailActivity

class Navigator(val app: Context) {
    fun switchToDetailsView(body: Intent.()-> Unit) {
        app.startActivity(Intent(app, DetailActivity::class.java).apply(body))
    }}
