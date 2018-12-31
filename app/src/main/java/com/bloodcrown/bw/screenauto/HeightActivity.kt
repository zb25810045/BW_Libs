package com.bloodcrown.bw.screenauto

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.bloodcrown.baselib.screen.ScreenAutoManager
import com.bloodcrown.bw.R

class HeightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)

        ScreenAutoManager.instance.cleanResize(this)
        ScreenAutoManager.instance.resizeDisplayMetrics(this, 1920f, ScreenAutoManager.BASE_LINE_HRIGHT)

        setContentView(R.layout.activity_height)
    }
}
