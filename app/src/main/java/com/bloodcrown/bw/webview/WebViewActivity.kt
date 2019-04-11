package com.bloodcrown.bw.webview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bloodcrown.bw.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        view_myWebView.loadUrl("http://www.baidu.com")
    }
}
