package com.bloodcrown.bw.pieview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bloodcrown.bw.R
import kotlinx.android.synthetic.main.activity_pie_view.*

class PieViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_view)

        view_pieview.post {

            var data = mutableListOf<Float>()
            data.add(100f)
            data.add(200f)
            data.add(200f)
            data.add(300f)
            data.add(300f)
            data.add(300f)
            data.add(200f)
            data.add(200f)
            data.add(300f)
            data.add(200f)
            view_pieview.setData(data)
        }
    }
}
