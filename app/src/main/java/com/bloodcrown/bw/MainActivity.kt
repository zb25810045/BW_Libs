package com.bloodcrown.bw

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bloodcrown.basecomponents.toast.ToastComponent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var num: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // toast 组件测试
        btn_toast.setOnClickListener({

            var toastMessage: String = "第：$num 次显示"
            num++
            Log.d("AA", "num = "+num +",message = "+toastMessage)
            ToastComponent.instance.show(toastMessage)
        })
    }
}
