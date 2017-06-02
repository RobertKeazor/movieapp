package com.example.kotlin.movieapp.ui.dagger.components

import com.example.kotlin.movieapp.scope.ActivityScope
import com.example.kotlin.movieapp.ui.dagger.modules.MainModule
import com.example.kotlin.movieapp.ui.main.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}
