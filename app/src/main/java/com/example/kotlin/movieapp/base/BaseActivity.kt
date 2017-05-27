package com.example.kotlin.movieapp.base

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes

abstract class BaseActivity<VM: BaseViewModel, VDB: ViewDataBinding> : LifecycleActivity() {
    protected lateinit var mViewModel: VM
    protected lateinit var mViewBinding: VDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(getViewModelClass())
        mViewBinding = DataBindingUtil.setContentView<VDB>(this, getLayout())
        setupViewBinding()
    }

    abstract fun getViewModelClass() : Class<VM>

    @LayoutRes
    abstract fun getLayout() : Int

    abstract fun setupViewBinding()
}
