package com.bloodcrown.bw

import android.app.Application
import com.bloodcrown.basecomponents.toast.ToastComponent

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

    }
}