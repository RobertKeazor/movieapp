package com.example.kotlin.movieapp.ui.movieDetail

import com.example.kotlin.movieapp.app.AppComponent
import com.example.kotlin.movieapp.ui.base.BaseComponent
import com.example.kotlin.movieapp.ui.base.ViewScope
import dagger.Component

@ViewScope
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(DetailModule::class)
)

interface DetailComponent : BaseComponent<DetailActivity>