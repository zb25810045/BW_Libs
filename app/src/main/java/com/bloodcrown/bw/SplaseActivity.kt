package com.bloodcrown.bw

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bloodcrown.basecomponents.applicaton.ApplicationManage
import kotlinx.android.synthetic.main.activity_splase.*

class SplaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splase)

        view_root.postDelayed({
            ApplicationManage.instance.exitmanage.startActivityProxy(this, Intent(this@SplaseActivity, MainActivity::class.java))
            this@SplaseActivity.finish()
        }, 1000)
    }
}
