package com.bloodcrown.bw.list.standar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.animation.AnimationUtils
import com.bloodcrown.basecomponents.view.list.BWItemAnimator
import com.bloodcrown.bw.R
import com.bloodcrown.bw.list.Book
import com.bloodcrown.bw.list.Cat
import kotlinx.android.synthetic.main.activity_base.*


class StandardActivity : AppCompatActivity() {

    var persenter: StandarPersenter = StandarPersenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        var layoutManage = LinearLayoutManager(this)
        layoutManage.orientation = LinearLayoutManager.VERTICAL

        var adapter = StandarAdapter()
        adapter.data = getData()
        adapter.persenter = persenter

        recy_standar.layoutManager = layoutManage
        var itemAnimator = BWItemAnimator()
        itemAnimator.addDuration = 500
        itemAnimator.removeDuration = 500

        recy_standar.itemAnimator = itemAnimator
        recy_standar.adapter = adapter

        btn_add.setOnClickListener({
            adapter.addData(Book("我是大大大大大大大", 155))
        })

        btn_remove.setOnClickListener({
            adapter.removeData()
        })

        window.decorView.post {
            val animation = AnimationUtils.loadLayoutAnimation(this@StandardActivity, R.anim.la_list_layout)
            recy_standar.setLayoutAnimation(animation)
        }
    }

    fun getData(): MutableList<Any> {

        var data = mutableListOf<Any>()
        data.add(Book("Android", 123))
        data.add(Cat("学喵叫", 123))
        data.add(Book("Android", 123))
        data.add(Cat("学喵叫", 123))
        data.add(Book("Android", 123))
        data.add(Cat("学喵叫", 123))
        data.add(Book("Android", 123))
        data.add(Cat("学喵叫", 123))
        data.add(Book("Android", 123))
        data.add(Cat("学喵叫", 123))
        data.add(Book("Android", 123))
        data.add(Cat("学喵叫", 123))
        data.add(Book("Android", 123))
        data.add(Cat("学喵叫", 123))
        data.add(Book("Android", 123))
        data.add(Cat("学喵叫", 123))
        data.add(Book("Android", 123))
        data.add(Cat("学喵叫", 123))
        data.add(Book("Android", 123))
        data.add(Cat("学喵叫", 123))
        data.add(Book("Android", 123))
        data.add(Cat("学喵叫", 123))
        data.add(Book("Android", 123))
        data.add(Cat("学喵叫", 123))

        return data
    }


}
