package com.bloodcrown.bw.list.standar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.bloodcrown.bw.R
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
        recy_standar.adapter = adapter

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
