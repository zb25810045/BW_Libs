package com.bloodcrown.basecomponents.view.list

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/11/30 下午12:08
 * 描述 ：
 */
abstract class BaseAdapter(var data: MutableList<Any> = mutableListOf()) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        return BaseViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent?.context), viewType, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

}