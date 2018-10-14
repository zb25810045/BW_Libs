package com.bloodcrown.bw

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bloodcrown.basecomponents.toast.ToastComponent
import com.bloodcrown.bw.customeview.CustomeViewActivity
import com.bloodcrown.bw.spannable.SpannableActivity
import com.bloodcrown.bw.textview.TextViewActivity
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
            Log.d("AA", "num = " + num + ",message = " + toastMessage)
            ToastComponent.instance.show(toastMessage)
        })


        // spannableString 工具
        btn_spannable.setOnClickListener({

            var intent: Intent = Intent(this@MainActivity, SpannableActivity::class.java)
            this@MainActivity.startActivity(intent)
        })

        // textview 效果
        btn_textview.setOnClickListener({

            var intent: Intent = Intent(this@MainActivity, TextViewActivity::class.java)
            this@MainActivity.startActivity(intent)
        })

        btn_customeview.setOnClickListener( {

            var intent: Intent = Intent(this@MainActivity, CustomeViewActivity::class.java)
            this@MainActivity.startActivity(intent)
        } )




    }
}
