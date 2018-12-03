package com.bloodcrown.bw.list

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bloodcrown.bw.R
import com.bloodcrown.bw.list.difftils.DiffUtilsActivity
import com.bloodcrown.bw.list.standar.StandardActivity
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        // 列表 base 层封装及基础操作
        btn_base.setOnClickListener {
            var intent: Intent = Intent(this@RecyclerViewActivity, StandardActivity::class.java)
            this@RecyclerViewActivity.startActivity(intent)
        }

         btn_diffutils.setOnClickListener {
            var intent: Intent = Intent(this@RecyclerViewActivity, DiffUtilsActivity::class.java)
            this@RecyclerViewActivity.startActivity(intent)
        }

    }
}
