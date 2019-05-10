package com.bloodcrown.bw

import android.app.Application
import android.util.Log
import com.bloodcrown.basecomponents.applicaton.ApplicationManage
import com.bloodcrown.basecomponents.toast.ToastComponent
import com.bloodcrown.baselib.net.HttpClient
import com.bloodcrown.baselib.screen.ScreenAutoManager
import okhttp3.*
import org.json.JSONObject
import java.util.concurrent.TimeUnit


/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/8/30 上午1:05
 * 描述 ：
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ScreenAutoManager.instance.init(this, 1080.0f, ScreenAutoManager.BASE_LINE_WIDTH)

        ApplicationManage.init(this)
        ApplicationManage.instance.addObserver { lifecycleMessage ->
            when (lifecycleMessage.type) {
                ApplicationManage.MessageType.MESSAGE_ACTIVITY_CREATE -> {
                    if (lifecycleMessage.activity != null) ScreenAutoManager.instance.onActivityCreated(lifecycleMessage.activity)
                    Log.d("AA", "MESSAGE_ACTIVITY_CREATE")
                }
                ApplicationManage.MessageType.MESSAGE_ACTIVITY_START -> {
                    if (lifecycleMessage.activity != null) ScreenAutoManager.instance.onActivityStarted(lifecycleMessage.activity)
                    Log.d("AA", "MESSAGE_ACTIVITY_START")
                }
                ApplicationManage.MessageType.MESSAGE_ACTIVITY_RESUME -> {
                    if (lifecycleMessage.activity != null) ScreenAutoManager.instance.onActivityResumed(lifecycleMessage.activity)
                    Log.d("AA", "MESSAGE_ACTIVITY_RESUME")
                }
                ApplicationManage.MessageType.MESSAGE_ACTIVITY_PAUSE -> Log.d("AA", "MESSAGE_ACTIVITY_PAUSE")
                ApplicationManage.MessageType.MESSAGE_ACTIVITY_STOP -> Log.d("AA", "MESSAGE_ACTIVITY_STOP")
                ApplicationManage.MessageType.MESSAGE_ACTIVITY_SAVEINSTANCESTATE -> Log.d("AA", "MESSAGE_ACTIVITY_SAVEINSTANCESTATE")
                ApplicationManage.MessageType.MESSAGE_ACTIVITY_DESTROYED -> Log.d("AA", "MESSAGE_ACTIVITY_DESTROYED")

                ApplicationManage.MessageType.MESSAGE_APP_START -> Log.d("AA", "MESSAGE_APP_START")
                ApplicationManage.MessageType.MESSAGE_APP_EXIT -> Log.d("AA", "MESSAGE_APP_EXIT")
                ApplicationManage.MessageType.MESSAGE_APP_FORNT -> Log.d("AA", "MESSAGE_APP_FORNT")
                ApplicationManage.MessageType.MESSAGE_APP_BACKGROUD -> Log.d("AA", "MESSAGE_APP_BACKGROUD")
            }
        }

        // 初始化 toast 组件
        ToastComponent.init(this)
//        StallBuster.getInstance().init(this)

        // 初始化网络配置
        initHttp()

    }

    fun initHttp() {

        var baseUrl = "https://api.douban.com/v2/"

        /**
         * 请求头拦截器
         * 1. 可以判断网络地址是否需要特殊处理
         * if (s.contains("androidxx")) {
        request = request.newBuilder().mUrl("http://www.androidxx.cn").build();
        }
         */
        var headInterceptor = object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                var request = chain.request()

                // 获取 post MD5 加密串
                var md5: String = ""
                var method: String = request.method()
                if (method.equals("post")) {
                    val requestBody = request.body()
                    if (requestBody is FormBody && requestBody.size() > 0) {
                        var json = JSONObject()
                        var formBody: FormBody = requestBody as FormBody
                        formBody.size()
                        for (index in 0..formBody.size()) {
                            json.put(formBody.encodedName(index), formBody.encodedValue(index))
                        }
                        md5 = json.toString()
                    }
                }

                // 添加请求头
                var requestBuilder: Request = request.newBuilder()
                        .addHeader("Connection", "AA")
                        .addHeader("token", "token-value")
                        .addHeader("MD5", md5)
                        .method(request.method(), request.body())
                        .build()
                return chain.proceed(requestBuilder);
            }
        }

        var httpBuild = OkHttpClient.Builder()
                .connectTimeout(HttpClient.connectTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(HttpClient.readTimeout, TimeUnit.MILLISECONDS)
                .writeTimeout(HttpClient.writeTimeout, TimeUnit.MILLISECONDS)
//                .addInterceptor(headInterceptor)

        HttpClient.instance.init(baseUrl, httpBuild)
    }

}