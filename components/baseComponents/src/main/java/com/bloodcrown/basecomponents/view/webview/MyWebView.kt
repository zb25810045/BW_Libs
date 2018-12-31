package com.bloodcrown.basecomponents.view.webview

import android.content.Context
import android.graphics.Bitmap
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.bloodcrown.basecomponents.R
import kotlinx.android.synthetic.main.layout_mywebview.view.*


/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/12/29 下午7:26
 * 描述 ：
 */
class MyWebView : ConstraintLayout {

    var mCallBack: MyWebViewCallBack? = null
    var mUrl: String = ""

    @JvmOverloads
    constructor(context: Context, attributeSet: AttributeSet? = null, defAttrStyle: Int = 0)
            : super(context, attributeSet, defAttrStyle) {

        initView()
        initWebViewSetting()
        initWebViewListener()
    }

    /**
     * 添加默认 layout 进来
     */
    private fun initView() {
        LayoutInflater.from(context).inflate(R.layout.layout_mywebview, this, true)
    }

    /**
     * 设置 webview 的各种设置
     */
    private fun initWebViewSetting() {

        var settings: WebSettings = view_webView.settings

        /**
         * js 交互设置
         */
        settings.javaScriptEnabled = true // 默认false，设置true后我们才能在WebView里与我们的JS代码进行交互
        settings.javaScriptCanOpenWindowsAutomatically = true // 设置JS是否可以打开WebView新窗口

        /**
         * 手势缩放设置
         */
        settings.setSupportZoom(true) // 支持缩放
        settings.builtInZoomControls = true // 支持手势缩放
        settings.displayZoomControls = false // 不显示缩放按钮

        /**
         * 缓存，数据库设置
         */
        settings.databaseEnabled = true//数据库存储API是否可用，默认值false。
        settings.saveFormData = true//WebView是否保存表单数据，默认值true。
        settings.domStorageEnabled = true//DOM存储API是否可用，默认false。
        settings.setGeolocationEnabled(true)//定位是否可用，默认为true。
        settings.setAppCacheEnabled(true)//应用缓存API是否可用，默认值false, 结合setAppCachePath(String)使用。

        /**
         * 自适应设置
         */
        settings.useWideViewPort = true // 将图片调整到适合WebView的大小
        settings.loadWithOverviewMode = true // 自适应屏幕

        /**
         * 滚动样式设置
         */
        view_webView.isHorizontalScrollBarEnabled = false//去掉webview的滚动条,水平不显示
        view_webView.isScrollbarFadingEnabled = true
        view_webView.scrollBarStyle = View.SCROLLBARS_OUTSIDE_OVERLAY
        view_webView.overScrollMode = View.OVER_SCROLL_NEVER // 取消WebView中滚动或拖动到顶部、底部时的阴影
    }

    /**
     * 设置 webview  监听
     */
    private fun initWebViewListener() {

        view_webView.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

                view_progressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                view_progressBar.visibility = View.GONE
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                var result = false

                if (mCallBack != null) {
                    result = mCallBack?.shouldOverrideUrlLoading(view, url)!!
                    return result
                }
                view_webView.loadUrl(url)
                return result
            }
        }

        view_webView.webChromeClient = object : WebChromeClient() {

            // 更新进度
            override fun onProgressChanged(view: WebView?, progress: Int) {
                super.onProgressChanged(view, progress)

                if (progress >= 100) {
                    view_progressBar.visibility = View.GONE
                    return
                }

                if (view_progressBar.visibility == View.GONE) {
                    view_progressBar.visibility = View.VISIBLE
                }

                view_progressBar.progress = progress
            }
        }

    }

    fun loadUrl(url: String) {
        this.mUrl = url
        view_webView.loadUrl(url)
    }

    fun onDestroy() {
        view_webView.setVisibility(View.GONE)
        view_webView.destroy()
    }

    fun goBack(): Boolean {
        if (view_webView.canGoBack()) {
            view_webView.goBack()
            return true
        }
        return false
    }

    interface MyWebViewCallBack {

        fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean
    }

}