package com.example.kotlin.movieapp.ui.main

import com.example.kotlin.movieapp.R
import com.example.kotlin.movieapp.app.App
import com.example.kotlin.movieapp.databinding.ActivityMainBinding
import com.example.kotlin.movieapp.ui.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    override val viewModelFactory: MainViewModel.Factory = MainViewModel.Factory(App.get)
    override val viewModelClass = MainViewModel::class.java
    override val layoutResId = R.layout.activity_main

    override fun setupViewBinding() {
        viewBinding.viewModel = viewModel
    }
}
