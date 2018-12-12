package com.bloodcrown.bw.list.difftils

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.animation.AnimationUtils
import com.bloodcrown.basecomponents.view.list.BWItemAnimator
import com.bloodcrown.bw.R
import com.bloodcrown.bw.list.Book
import com.bloodcrown.bw.list.Cat
import kotlinx.android.synthetic.main.activity_diffutils.*

class DiffUtilsActivity : AppCompatActivity() {

    var persenter: DiffPersenter = DiffPersenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diffutils)

        var layoutManage = LinearLayoutManager(this)
        layoutManage.orientation = LinearLayoutManager.VERTICAL

        var adapter = DiffAdapter()
        adapter.persenter = persenter

        recy_diff.layoutManager = layoutManage
        var itemAnimator = BWItemAnimator()
        itemAnimator.addDuration = 300
        itemAnimator.removeDuration = 300
        itemAnimator.changeDuration = 300
        itemAnimator.moveDuration = 300

        recy_diff.itemAnimator = itemAnimator
        recy_diff.adapter = adapter

        btn_diff1.setOnClickListener({
            adapter.refreshDatabyDiffUtils(getDataByDiff1())
        })

        btn_diff2.setOnClickListener({
            adapter.refreshDatabyDiffUtils(getDataByDiff2())
        })

        btn_diff3.setOnClickListener({
            adapter.refreshDatabyDiffUtils(getDataByDiff3())
        })

        window.decorView.post {
            val animation = AnimationUtils.loadLayoutAnimation(this@DiffUtilsActivity, R.anim.la_list_layout)
            recy_diff.setLayoutAnimation(animation)

            adapter.data = getData()
            adapter.notifyDataSetChanged()
        }
    }

    fun getData(): MutableList<Any> {

        var data = mutableListOf<Any>()
        data.add(Book("Book_1", 111))
        data.add(Book("Book_2", 111))
        data.add(Book("Book_3", 111))
        data.add(Cat("Cat_1", 222))
        data.add(Book("Book_4", 111))
        data.add(Cat("Cat_2", 222))
        data.add(Cat("Cat_3", 222))
        data.add(Cat("Cat_4", 222))
        data.add(Cat("Cat_5", 222))

        return data
    }

    fun getDataByDiff1(): MutableList<Any> {

        var data = mutableListOf<Any>()
        data.add(Book("Book_1", 111))
        data.add(Book("Book_3", 111))
        data.add(Cat("Cat_1", 222))
        data.add(Book("Book_4", 111))
        data.add(Cat("Cat_2", 222))
        data.add(Book("Book_2", 111))
        data.add(Cat("Cat_3", 222))
        data.add(Cat("Cat_4", 222))
        data.add(Cat("Cat_5", 222))
        return data
    }

    fun getDataByDiff2(): MutableList<Any> {

        var data = mutableListOf<Any>()
        data.add(Book("Book_11", 111))
        data.add(Book("Book_31", 111))
        data.add(Cat("Cat_11", 222))
        data.add(Book("Book_41", 111))
        data.add(Book("Book_2", 111))
        data.add(Cat("Cat_2", 222))
        data.add(Cat("Cat_3", 222))
        data.add(Cat("Cat_4", 222))
        data.add(Cat("Cat_5", 222))
        return data
    }

    fun getDataByDiff3(): MutableList<Any> {

        var data = mutableListOf<Any>()
        data.add(Book("Book_1", 111))
        data.add(Cat("Cat_11", 222))
        data.add(Cat("Cat_21", 222))
        data.add(Book("Book_21", 111))
        data.add(Book("Book_3", 111))
        data.add(Book("Book_4", 111))
        data.add(Cat("Cat_3", 222))
        data.add(Cat("Cat_4", 222))
        data.add(Cat("Cat_4", 222))
        data.add(Cat("Cat_5", 222))
        data.add(Cat("Cat_5", 222))
        data.add(Book("Book_3", 111))
        data.add(Book("Book_3", 111))
        data.add(Book("Book_3", 111))

        return data
    }

}