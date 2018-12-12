package com.bloodcrown.bw.net

import android.support.v7.util.DiffUtil
import com.bloodcrown.basecomponents.view.list.BaseAdapter
import com.bloodcrown.basecomponents.view.list.BaseViewHolder
import com.bloodcrown.bw.BR
import com.bloodcrown.bw.R
import com.bloodcrown.bw.databinding.ItemBook2Binding
import com.bloodcrown.repositroy.book.BookResponse

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/12/11 下午10:06
 * 描述 ：
 */
class BookAdapter : BaseAdapter<BookResponse.Book>() {

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_book2
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        if (holder.dataBinding is ItemBook2Binding) {
            holder.dataBinding.setVariable(BR.book, data.get(position) as BookResponse.Book)
            holder.dataBinding.executePendingBindings()
        }
    }

    override fun getDiffCllBack(oldData: MutableList<BookResponse.Book>, newData: MutableList<BookResponse.Book>): DiffUtil.Callback {
        return DiffCallback(oldData, newData)
    }

    class DiffCallback(var oldData: MutableList<BookResponse.Book>, var newData: MutableList<BookResponse.Book>) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldData.size
        }

        override fun getNewListSize(): Int {
            return newData.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

            if (!oldData.get(oldItemPosition).javaClass.equals(newData.get(newItemPosition))) return false
            if (oldData.get(oldItemPosition) is BookResponse.Book && newData.get(newItemPosition) is BookResponse.Book) {
                var oldBook: BookResponse.Book = oldData.get(oldItemPosition) as BookResponse.Book
                var newBook: BookResponse.Book = newData.get(newItemPosition) as BookResponse.Book
                return oldBook.title.equals(newBook.title)
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