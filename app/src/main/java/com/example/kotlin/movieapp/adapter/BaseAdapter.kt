package com.example.kotlin.movieapp.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.kotlin.movieapp.BR

abstract class BaseAdapter<out T:Any>(val items: List<T>): RecyclerView.Adapter<BaseViewHolder>() {

    abstract fun getLayout(): Int

    abstract fun getItemForPosition(position: Int): T

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        holder?.binding?.setVariable(BR.item, getItemForPosition(position))
        holder?.binding?.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder =
        BaseViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent?.context),  getLayout(), parent, false))


    override fun getItemCount() = items.size
}

class BaseViewHolder(val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root)
