package com.bloodcrown.baselib.net.interceptor

import android.util.Log
import com.bloodcrown.baselib.net.exception.ApiException
import okhttp3.Interceptor
import okhttp3.Response
import kotlin.math.log

class ErrorInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()
        val response = chain.proceed(request)
        Log.d( "AA","response = " +response.toString())
        if (401 == response.code()) {
            throw ApiException("身份验证错误!")
        } else if (403 == response.code()) {
            throw ApiException("禁止访问!")
        } else if (404 == response.code()) {
            throw ApiException("链接错误")
        } else if (408 == response.code()) {
            throw ApiException("请求超时!")
        } else if (503 == response.code()) {
            throw ApiException("服务器升级中!")
        } else if (500 == response.code()) {
            throw ApiException("服务器内部错误!")
        }
        return response
    }
}