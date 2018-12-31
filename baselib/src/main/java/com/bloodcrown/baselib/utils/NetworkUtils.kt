package com.bloodcrown.baselib.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/12/29 下午10:34
 * 描述 ： 网络工具
 *
 * 1. 判断当前网络状态是否有效 -> isNetworkAvailable
 */
class NetworkUtils {

    /**
     * 判断当前网络状态是否有效
     *
     * @return
     */
    fun isNetworkAvailable(context: Context): Boolean {

        // 获取系统的连接服务
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetInfo = connectivityManager.activeNetworkInfo
        return activeNetInfo != null && activeNetInfo.isConnected
    }

}