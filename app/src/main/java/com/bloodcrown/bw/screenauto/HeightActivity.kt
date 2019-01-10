package com.bloodcrown.bw.screenauto

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.WindowManager
import com.bloodcrown.baselib.screen.ScreenAutoManager
import com.bloodcrown.bw.R
import com.bloodcrown.bw.databinding.ActivityHeightBinding

class HeightActivity : AppCompatActivity() {

    lateinit var binding: ActivityHeightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)

        ScreenAutoManager.instance.cleanResize(this)
        ScreenAutoManager.instance.resizeDisplayMetrics(this, 1920f, ScreenAutoManager.BASE_LINE_HRIGHT)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_height)

        setContentView(R.layout.activity_height)

        Log.d( "AA","AA1" )
        Log.d( "AA","AA2" )

    }
}
