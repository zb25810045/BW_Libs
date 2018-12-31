package com.bloodcrown.bw.screenauto

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bloodcrown.baselib.screen.ScreenAutoManager
import com.bloodcrown.bw.R

class WidthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ScreenAutoManager.instance.cleanResize(this)
        ScreenAutoManager.instance.resizeDisplayMetrics(this, 1008f, ScreenAutoManager.BASE_LINE_WIDTH)

        setContentView(R.layout.activity_width)

        Log.d("AA", "WidthActivity : onCreate")
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)

        Log.d("AA", "onConfigurationChanged : " + newConfig?.orientation)
    }

}
