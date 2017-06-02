package com.example.kotlin.movieapp.ui.main

import com.example.kotlin.movieapp.ui.base.BaseComponent
import com.example.kotlin.movieapp.ui.base.ViewScope
import dagger.Subcomponent

@ViewScope
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent : BaseComponent<MainActivity>
