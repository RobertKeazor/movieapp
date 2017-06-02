package com.example.kotlin.movieapp.extensions

import android.app.Activity
import com.example.kotlin.movieapp.app.App

val Activity.app: App
    get() = application as App
