package com.example.kotlin.movieapp.ui.base

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import com.example.kotlin.movieapp.BR
import javax.inject.Inject

abstract class BaseActivity<V, VM: BaseViewModel, VMF: ViewModelProvider.Factory, VDB: ViewDataBinding, out C: BaseComponent<V>> : LifecycleActivity() {
    protected abstract val viewModelClass: Class<VM>
    protected abstract val layoutResId: Int
    protected abstract val component: C

    @Inject
    protected lateinit var viewModelFactory: VMF
    protected lateinit var viewModel: VM
    protected lateinit var viewBinding: VDB

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBeforeViewLoad(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView<VDB>(this, layoutResId)
        component.inject(this as V)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
        viewBinding.setVariable(BR.viewModel, viewModel)
        viewModel.view = this
        onViewLoad(savedInstanceState)
    }

    open fun onBeforeViewLoad(savedInstanceState: Bundle?) {
        //Intentionally empty so that subclasses can override if necessary
    }

    open fun onViewLoad(savedInstanceState: Bundle?) {
        //Intentionally empty so that subclasses can override if necessary
    }
}
