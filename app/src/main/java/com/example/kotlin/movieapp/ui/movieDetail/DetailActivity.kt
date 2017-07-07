package com.example.kotlin.movieapp.ui.movieDetail

import android.os.Bundle
import com.example.kotlin.movieapp.R
import com.example.kotlin.movieapp.databinding.ActivityMovieDetailBinding
import com.example.kotlin.movieapp.ext.app
import com.example.kotlin.movieapp.model.Movie
import com.example.kotlin.movieapp.ui.base.BaseActivity

class DetailActivity : BaseActivity<DetailActivity, DetailViewModel, DetailViewModel.Factory, ActivityMovieDetailBinding, DetailComponent>() {
    override val viewModelClass = DetailViewModel::class.java
    override val layoutResId = R.layout.activity_movie_detail
    override val component by lazy {
        DaggerDetailComponent
                .builder()
                .appComponent(app.component)
                .detailModule(DetailModule())
                .build()
    }

    override fun onViewLoad(savedInstanceState: Bundle?) {
        super.onViewLoad(savedInstanceState)
        var movie : Movie = intent.getParcelableExtra<Movie>("movie")
        viewModel.initalize(movie)


    }
}
