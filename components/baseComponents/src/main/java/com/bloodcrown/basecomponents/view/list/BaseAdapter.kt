package com.bloodcrown.basecomponents.view.list

import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/11/30 下午12:08
 * 描述 ：
 */
abstract class BaseAdapter<T>(var data: MutableList<T> = mutableListOf()) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    abstract fun getDiffCllBack(oldData: MutableList<T>, newData: MutableList<T>): DiffUtil.Callback

    fun refreshData(newData: MutableList<T>) {
        this.data = newData
        this.notifyDataSetChanged()
    }

    fun addItem(positon: Int, data: T) {
        this.data.add(positon, data)
        notifyItemInserted(positon)
    }

    fun removeItem(positon: Int) {
        this.data.removeAt(positon)
        notifyItemRemoved(positon)
    }

    fun refreshDatabyDiffUtils(newData: MutableList<T>) {

        var result: DiffUtil.DiffResult = DiffUtil.calculateDiff(getDiffCllBack(this.data, newData), true)
        this.data = newData
        result.dispatchUpdatesTo(this)
    }

}