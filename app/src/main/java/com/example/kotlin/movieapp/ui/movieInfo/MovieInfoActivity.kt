package com.example.kotlin.movieapp.ui.movieInfo

import com.example.kotlin.movieapp.R
import com.example.kotlin.movieapp.databinding.ActivityMovieInfoBinding
import com.example.kotlin.movieapp.ext.app
import com.example.kotlin.movieapp.ui.base.BaseActivity

class MovieInfoActivity : BaseActivity<MovieInfoActivity, MovieInfoViewModel, MovieInfoViewModel.Factory, ActivityMovieInfoBinding, MovieInfoComponent>() {
    override val viewModelClass = MovieInfoViewModel::class.java
    override val layoutResId = R.layout.activity_movie_info
    override val component by lazy {
        DaggerMovieInfoComponent
                .builder()
                .appComponent(app.component)
                .movieInfoModule(MovieInfoModule())
                .build()
    }
}
