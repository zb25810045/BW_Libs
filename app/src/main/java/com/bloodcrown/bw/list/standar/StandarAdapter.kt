package com.bloodcrown.bw.list.standar

import android.support.v7.util.DiffUtil
import com.bloodcrown.basecomponents.view.list.BaseAdapter
import com.bloodcrown.basecomponents.view.list.BaseViewHolder
import com.bloodcrown.bw.BR
import com.bloodcrown.bw.R
import com.bloodcrown.bw.list.Book
import com.bloodcrown.bw.list.Cat
import com.bloodcrown.bw.list.difftils.DiffPersenter

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/12/1 上午3:44
 * 描述 ：
 */
class StandarAdapter : BaseAdapter() {

    lateinit var persenter: StandarPersenter

    override fun getItemViewType(position: Int): Int {

        if (data.get(position) is Book) return R.layout.item_book
        if (data.get(position) is Cat) return R.layout.item_cat

        return R.layout.item_book
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {

        if (data.get(position) is Book) {
            holder?.dataBinding?.setVariable(BR.book, data.get(position) as Book)
            holder?.dataBinding?.setVariable(BR.persenter, persenter)
            holder?.dataBinding?.executePendingBindings()
        }
        if (data.get(position) is Cat) {
            holder?.dataBinding?.setVariable(BR.cat, data.get(position) as Cat)
            holder?.dataBinding?.setVariable(BR.persenter, persenter)
            holder?.dataBinding?.executePendingBindings()
        }
    }

    override fun getDiffCllBack(oldData: MutableList<Any>, newData: MutableList<Any>): DiffUtil.Callback {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun addData(newData: Any) {
        data.add(1, newData)
        notifyItemInserted(1)
    }

    fun removeData() {
        data.removeAt(2)
        notifyItemRemoved(2)
    }

}