package com.bloodcrown.bw.customeview.taiji

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import com.bloodcrown.bw.R
import kotlinx.android.synthetic.main.activity_taiji.*

class TaijiActivity : AppCompatActivity() {

    var degree: Float = 0f

    var handle: Handler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            degree += 5
            view_taiji.setDegree(degree)
            sendEmptyMessageDelayed(0, 10)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taiji)

        view_taiji.post({
            handle.sendEmptyMessage(5)
        })
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        handle.removeCallbacks { }
    }
}
