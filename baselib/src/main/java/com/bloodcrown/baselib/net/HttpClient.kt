package com.bloodcrown.baselib.net

import com.bloodcrown.baselib.net.api.CommonService
import com.bloodcrown.baselib.net.interceptor.ErrorInterceptor
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/12/9 下午9:42
 * 描述 ：
 *
 *  2019.1.16 ->  改名为 HttpClient ，感觉还是 HttpClient 这样命名更清晰
 *
 */
class HttpClient {

    lateinit private var okHttpClient: OkHttpClient
    lateinit private var retrofit: Retrofit
    lateinit var baseUrl: String

    companion object {

        var connectTimeout: Long = 10 * 1000
        var readTimeout: Long = 10 * 1000
        var writeTimeout: Long = 10 * 1000

        var instance: HttpClient = HttpClient()
    }

    /**
     * 初始化网络数据，使用 OkHttpClient.Builder 传入主要参数到 ohkttp 对象中
     */
    fun init(baseUrl: String, builder: OkHttpClient.Builder?) {

        if (builder == null) {
            okHttpClient = OkHttpClient.Builder()
                    // 超时时间
                    .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                    .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                    .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS)
                    // 网络相应 code 码处理，不含 app 业务 code 处理
                    .addInterceptor(ErrorInterceptor())
                    .addInterceptor(HttpLoggingInterceptor())
                    .build()
        } else {
            okHttpClient = builder
                    .addInterceptor(ErrorInterceptor())
                    .addInterceptor(HttpLoggingInterceptor())
                    .build()
        }

        retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    /**
     * 标准 get 请求
     */
    fun get(url: String, options: Map<String, String>): Observable<ResponseBody> {
        return retrofit.create(CommonService::class.java).getMethod(url, options).subscribeOn(Schedulers.io())
    }

    /**
     * 标准 get 请求
     */
    fun get(url: String): Observable<ResponseBody> {
        return retrofit.create(CommonService::class.java).getMethod(url).subscribeOn(Schedulers.io())
    }

    /**
     * 标准 post 请求
     */
    fun post(url: String, options: Map<String, String>): Observable<ResponseBody> {
        return retrofit.create(CommonService::class.java).postMethod(url, options).subscribeOn(Schedulers.io())
    }

    /**
     * 支持用户使用自己定义的 RetrofitService，而非公共的 RetrofitService
     */
    fun <S> createRetrofitService(service: Class<S>): S {
        return retrofit.create(service)
    }

}