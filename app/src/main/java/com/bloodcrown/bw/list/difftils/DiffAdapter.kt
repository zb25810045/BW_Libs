package com.bloodcrown.bw.list.difftils

import android.support.v7.util.DiffUtil
import android.util.Log
import com.bloodcrown.basecomponents.view.list.BaseAdapter
import com.bloodcrown.basecomponents.view.list.BaseViewHolder
import com.bloodcrown.bw.BR
import com.bloodcrown.bw.R
import com.bloodcrown.bw.list.Book
import com.bloodcrown.bw.list.Cat

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/12/1 上午3:44
 * 描述 ：
 */
class DiffAdapter : BaseAdapter() {

    lateinit var persenter: DiffPersenter

    override fun getItemViewType(position: Int): Int {

        if (data.get(position) is Book) return R.layout.item_book_diff
        if (data.get(position) is Cat) return R.layout.item_cat_diff

        return R.layout.item_book
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {

        Log.d("AA", "position:" + position)
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

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int, payloads: MutableList<Any>?) {
        onBindViewHolder(holder, position)
    }

    override fun getDiffCllBack(oldData: MutableList<Any>, newData: MutableList<Any>): DiffUtil.Callback {
        return DiffCallback(oldData, newData)
    }

    class DiffCallback(var oldData: MutableList<Any>, var newData: MutableList<Any>) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldData.size
        }

        override fun getNewListSize(): Int {
            return newData.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            if (!oldData.get(oldItemPosition).javaClass.equals(newData.get(newItemPosition).javaClass)) return false
            if (oldData.get(oldItemPosition) is Book && newData.get(newItemPosition) is Book) {
                var oldBook: Book = oldData.get(oldItemPosition) as Book
                var newBook: Book = newData.get(newItemPosition) as Book
                return oldBook.name.equals(newBook.name)
            }
            if (oldData.get(oldItemPosition) is Cat && newData.get(newItemPosition) is Cat) {
                var oldCat: Cat = oldData.get(oldItemPosition) as Cat
                var newCat: Cat = newData.get(newItemPosition) as Cat
                return oldCat.name.equals(newCat.name)
            }
            return false
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldData.get(oldItemPosition).equals(newData.get(newItemPosition))
        }

        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            return null
        }
    }
}