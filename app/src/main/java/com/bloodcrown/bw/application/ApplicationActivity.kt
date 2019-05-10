package com.bloodcrown.bw.application

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.bloodcrown.basecomponents.applicaton.ApplicationManage
import com.bloodcrown.basecomponents.applicaton.state.StateManage
import com.bloodcrown.bw.R
import kotlinx.android.synthetic.main.activity_application.*

class ApplicationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application)

        btn_exit1.setOnClickListener {
            ApplicationManage.instance.exitmanage.exitApp()
        }

        btn_exit2.setOnClickListener {
            ApplicationManage.instance.exitmanage.exitAppBySystem()
        }

        btn_state.setOnClickListener {
            val currentState = ApplicationManage.instance.getCurrentState()
            var message: String = ""
            when (currentState) {
                StateManage.STATE_APP_NO -> message = "没启动"
                StateManage.STATE_APP_FORNT -> message = "前台"
                StateManage.STATE_APP_BACKGROUD -> message = "后台"
            }

            Toast.makeText(this, "当前 app 的状态为：$message", Toast.LENGTH_SHORT).show()
        }
    }
}
