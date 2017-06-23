package com.example.kotlin.movieapp.adapter

import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.kotlin.movieapp.BR

abstract class BaseAdapter<T: Any, out H>(val items: ObservableArrayList<T>): RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {
    abstract val handler: H
    abstract fun getLayout(position: Int): Int

    init {
        items.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableList<T>>() {
            override fun onItemRangeRemoved(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) = notifyItemRangeChanged(positionStart, itemCount)
            override fun onChanged(sender: ObservableList<T>?) = notifyDataSetChanged()
            override fun onItemRangeMoved(sender: ObservableList<T>?, positionStart: Int, toPosition: Int, itemCount: Int) = notifyDataSetChanged()
            override fun onItemRangeInserted(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) = notifyItemInserted(positionStart)
            override fun onItemRangeChanged(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) = notifyItemRangeChanged(positionStart, itemCount)
        })
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        holder?.bind(items[position], handler)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, position: Int): BaseViewHolder = BaseViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent?.context), getLayout(position), parent, false))
    override fun getItemCount() = items.size

    open class BaseViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        open fun bind(item: Any, handler: Any?) {
            binding.setVariable(BR.item, item)
            if (handler != null) binding.setVariable(BR.handler, handler)
            binding.executePendingBindings()
        }
    }
}
