package com.bloodcrown.bw

import android.app.Application
import com.bloodcrown.basecomponents.toast.ToastComponent
import com.bloodcrown.baselib.net.HttpManager
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
        request = request.newBuilder().url("http://www.androidxx.cn").build();
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
                .connectTimeout(HttpManager.connectTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(HttpManager.readTimeout, TimeUnit.MILLISECONDS)
                .writeTimeout(HttpManager.writeTimeout, TimeUnit.MILLISECONDS)
//                .addInterceptor(headInterceptor)

        HttpManager.instance.init(baseUrl, httpBuild)
    }

}