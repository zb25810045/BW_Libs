package com.bloodcrown.bw.screenauto

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bloodcrown.bw.R
import kotlinx.android.synthetic.main.activity_screen_auto.*

class ScreenAutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_auto)

        btn_width.setOnClickListener({

            var intent = Intent(this@ScreenAutoActivity, WidthActivity::class.java)
            this@ScreenAutoActivity.startActivity(intent)
        })

         btn_height.setOnClickListener({

            var intent = Intent(this@ScreenAutoActivity, HeightActivity::class.java)
            this@ScreenAutoActivity.startActivity(intent)
        })
    }
}
