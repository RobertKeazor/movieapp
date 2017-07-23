package com.example.kotlin.movieapp.ui.base

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import kotlin.properties.Delegates

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {
    var view: Activity by Delegates.notNull()


}
