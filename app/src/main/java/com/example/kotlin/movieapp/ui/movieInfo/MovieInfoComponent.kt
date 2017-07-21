package com.example.kotlin.movieapp.ui.movieInfo

import com.example.kotlin.movieapp.app.AppComponent
import com.example.kotlin.movieapp.ui.base.BaseComponent
import com.example.kotlin.movieapp.ui.base.ViewScope
import dagger.Component

@ViewScope
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(MovieInfoModule::class)
)

interface MovieInfoComponent : BaseComponent<MovieInfoActivity>