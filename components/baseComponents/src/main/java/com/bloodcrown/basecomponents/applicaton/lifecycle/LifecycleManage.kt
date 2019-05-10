package com.bloodcrown.basecomponents.applicaton.lifecycle

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.bloodcrown.basecomponents.applicaton.ApplicationManage
import com.bloodcrown.baselib.livedata.MyLiveData

/**
 * 作者 ： BloodCrown
 * 时间 ： 2019-05-08 21:38
 * 描述 ：
 */
class LifecycleManage {
    var lifecycleLivaData: MyLiveData<LifecycleMessage> = MyLiveData()

    /**
     * 初始化方法
     */
    fun init(application: Application) {
        registerActivityLifecycleCallbacks(application)
    }

    /**
     * 注册 application 生命周期回调函数，在对应的函数回调中发射对应的消息
     */
    private fun registerActivityLifecycleCallbacks(application: Application) {
        if (application == null) return

        application.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                lifecycleLivaData.sendValue(LifecycleMessage(type = ApplicationManage.MessageType.MESSAGE_ACTIVITY_CREATE, activity = activity, savedInstanceState = savedInstanceState))
            }

            override fun onActivityStarted(activity: Activity?) {
                lifecycleLivaData.sendValue(LifecycleMessage(type = ApplicationManage.MessageType.MESSAGE_ACTIVITY_START, activity = activity))
            }

            override fun onActivityResumed(activity: Activity?) {
                lifecycleLivaData.sendValue(LifecycleMessage(type = ApplicationManage.MessageType.MESSAGE_ACTIVITY_RESUME, activity = activity))
            }

            override fun onActivityPaused(activity: Activity?) {
                lifecycleLivaData.sendValue(LifecycleMessage(type = ApplicationManage.MessageType.MESSAGE_ACTIVITY_PAUSE, activity = activity))
            }

            override fun onActivityStopped(activity: Activity?) {
                lifecycleLivaData.sendValue(LifecycleMessage(type = ApplicationManage.MessageType.MESSAGE_ACTIVITY_STOP, activity = activity))
            }

            override fun onActivityDestroyed(activity: Activity?) {
                lifecycleLivaData.sendValue(LifecycleMessage(type = ApplicationManage.MessageType.MESSAGE_ACTIVITY_DESTROYED, activity = activity))
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
                lifecycleLivaData.sendValue(LifecycleMessage(type = ApplicationManage.MessageType.MESSAGE_ACTIVITY_SAVEINSTANCESTATE, activity = activity, savedInstanceState = outState))
            }
        })
    }

}