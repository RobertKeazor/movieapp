package com.example.kotlin.movieapp.ui.base

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle

abstract class BaseActivity<VM: BaseViewModel, VDB: ViewDataBinding> : LifecycleActivity() {
    protected abstract val viewModelFactory: ViewModelProvider.Factory
    protected abstract val viewModelClass: Class<VM>
    protected abstract val layoutResId: Int
    protected lateinit var viewModel: VM
    protected lateinit var viewBinding: VDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBeforeViewLoad(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
        viewBinding = DataBindingUtil.setContentView<VDB>(this, layoutResId)
        setupViewBinding()
        onViewLoad(savedInstanceState)
    }

    abstract fun setupViewBinding()

    open fun onBeforeViewLoad(savedInstanceState: Bundle?) {
        //Intentionally empty so that subclasses can override if necessary
    }

    open fun onViewLoad(savedInstanceState: Bundle?) {
        //Intentionally empty so that subclasses can override if necessary
    }
}
