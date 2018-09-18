package com.bloodcrown.basecomponents.toast

import android.app.Application
import android.util.Log
import android.widget.Toast

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/8/29 下午4:43
 * 描述 ：
 */
class ToastComponent {

    lateinit var toast: Toast
    lateinit var application: Application

    companion object {

        var TAG: String = ToastComponent::class.qualifiedName.toString()
        var DEFAULT_MESSAGE: String = "ToastHelper_default_message"
        var TIME_SHORT: Int = Toast.LENGTH_SHORT
        var TIME_LONG: Int = Toast.LENGTH_LONG
        var instance: ToastComponent = ToastComponent()

        fun init(application: Application) {
            if (application == null) {
                Log.d(TAG, "初始化失败，application = null")
                return
            }
            instance.application = application
            instance.toast = Toast.makeText(application, DEFAULT_MESSAGE, TIME_SHORT)
        }
    }

    fun show(info: String?, time: Int = TIME_SHORT) {
        if (toast == null) {
            toast = Toast.makeText(application, DEFAULT_MESSAGE, TIME_SHORT)
        }
        toast?.setText(info)
        toast?.duration = time
        toast?.show()
    }


}