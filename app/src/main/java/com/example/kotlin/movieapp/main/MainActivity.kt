package com.example.kotlin.movieapp.main

import com.example.kotlin.movieapp.R
import com.example.kotlin.movieapp.base.BaseActivity
import com.example.kotlin.movieapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    override fun getViewModelClass() = MainViewModel::class.java

    override fun getLayout() = R.layout.activity_main

    override fun setupViewBinding() {
        mViewBinding.viewModel = mViewModel
    }
}
