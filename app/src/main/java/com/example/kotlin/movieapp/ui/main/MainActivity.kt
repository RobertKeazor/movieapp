package com.example.kotlin.movieapp.ui.main

import com.example.kotlin.movieapp.R
import com.example.kotlin.movieapp.databinding.ActivityMainBinding
import com.example.kotlin.movieapp.extensions.app
import com.example.kotlin.movieapp.ui.base.BaseActivity
import com.example.kotlin.movieapp.ui.dagger.modules.MainModule
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    @Inject lateinit var factoryInjection: MainViewModel.Factory

    override val viewModelClass = MainViewModel::class.java
    override val layoutResId = R.layout.activity_main

    val component by lazy { app.component.plus(MainModule()) }

    override fun setupViewBinding() {
        viewBinding.viewModel = viewModel
    }

    override fun injectDependencies() {
        component.inject(this)
        viewModelFactory = factoryInjection
    }
}
