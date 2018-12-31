package com.bloodcrown.bw

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bloodcrown.basecomponents.toast.ToastComponent
import com.bloodcrown.bw.customeview.CustomeViewActivity
import com.bloodcrown.bw.list.RecyclerViewActivity
import com.bloodcrown.bw.net.NetActivity
import com.bloodcrown.bw.screenauto.ScreenAutoActivity
import com.bloodcrown.bw.spannable.SpannableActivity
import com.bloodcrown.bw.textview.TextViewActivity
import com.bloodcrown.bw.webview.WebViewActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var num: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

//        StatusBarUtils.setStatusBarColorByKITKAT(window, this, Color.YELLOW)
//        MeiZuStatusbarUtils.setStatusBarDarkIcon(window, true)

//        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ){
//            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//        }

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

        // 自定义 view 练手
        btn_customeview.setOnClickListener({

            var intent: Intent = Intent(this@MainActivity, CustomeViewActivity::class.java)
            this@MainActivity.startActivity(intent)
        })

        // recyclerview 练手
        btn_recyclerview.setOnClickListener({

            var intent: Intent = Intent(this@MainActivity, RecyclerViewActivity::class.java)
            this@MainActivity.startActivity(intent)
        })

        // 网络 练手
        btn_net.setOnClickListener({

            var intent: Intent = Intent(this@MainActivity, NetActivity::class.java)
            this@MainActivity.startActivity(intent)
        })

        // 自定义 webview
        btn_webview.setOnClickListener({

            var intent: Intent = Intent(this@MainActivity, WebViewActivity::class.java)
            this@MainActivity.startActivity(intent)
        })

        // 自定义 webview
         btn_screen.setOnClickListener({

            var intent: Intent = Intent(this@MainActivity, ScreenAutoActivity::class.java)
            this@MainActivity.startActivity(intent)
        })


    }
}
