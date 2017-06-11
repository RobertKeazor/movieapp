package com.example.kotlin.movieapp.adapter

import android.databinding.DataBindingUtil
import android.databinding.ObservableList
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.kotlin.movieapp.BR

abstract class BaseAdapter<T>(val items: ObservableList<T>): RecyclerView.Adapter<BaseViewHolder>() {

    abstract fun getLayout(): Int

    abstract fun getItemForPosition(position: Int): T

    val onListChangeListener = object: ObservableList.OnListChangedCallback<ObservableList<T>>() {
        override fun onItemRangeRemoved(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
            notifyItemRangeChanged(positionStart, itemCount)
        }

        override fun onChanged(sender: ObservableList<T>?) {
            notifyDataSetChanged()
        }

        override fun onItemRangeMoved(sender: ObservableList<T>?, positionStart: Int, toPosition: Int, itemCount: Int) {
            notifyDataSetChanged()
        }

        override fun onItemRangeInserted(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
            notifyItemInserted(positionStart)
        }

        override fun onItemRangeChanged(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
           notifyItemRangeChanged(positionStart, itemCount)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        holder?.binding?.setVariable(BR.item, getItemForPosition(position))
        holder?.binding?.executePendingBindings()
        items.addOnListChangedCallback(onListChangeListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder =
        BaseViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent?.context),  getLayout(), parent, false))

    override fun getItemCount() = items.size
}

class BaseViewHolder(val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root)
