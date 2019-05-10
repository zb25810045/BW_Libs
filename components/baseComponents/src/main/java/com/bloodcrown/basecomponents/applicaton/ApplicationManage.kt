package com.bloodcrown.basecomponents.applicaton

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.Lifecycle
import android.os.Bundle
import com.bloodcrown.basecomponents.applicaton.exit.ExitManage
import com.bloodcrown.basecomponents.applicaton.lifecycle.LifecycleManage
import com.bloodcrown.basecomponents.applicaton.lifecycle.LifecycleMessage
import com.bloodcrown.basecomponents.applicaton.state.StateManage

/**
 * 作者 ： BloodCrown
 * 时间 ： 2019-05-08 21:33
 * 描述 ：
 *  application 封装类，在方便提供 application 上下文对象的同时，
 *  也提供了一些功能
 *
 * 功能 ：
 *  1. Application 上下文代理，任何模块都不必关心 application 具体的实现类型
 *  有 ApplicationManage 在时刻都能获取全局上下文对象
 *
 *  2. 提供优雅退出 app 的功能，通过在主页面下面添加一个透明的 activity + singleTask 实现优雅退出
 *
 *  3. Application 的生命周期实现响应式，像 EventBus，RxBus 那样响应消息就行，另外我还添加了
 *  app 启动，退出，切入后台，切回前台的相应进来
 *
 *  4. 在实现功能3时，实现了 app 当前状态的保存，极大的方便了我们在注入推送时判断 app 是否启动等操作
 *
 *  最后说一点，我没有使用 ActivityManage 来判断 app 状态，因为 ActivityManage 存在适配问题，
 *  总有那么一小撮手机就是不配合，臣妾也是没办法呀~
 *
 */
class ApplicationManage {

    companion object Help {

        // 饿汉式单例，加上同步限制，这样可以避免 application 操作类单例为null 的情况
        val instance: ApplicationManage by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            return@lazy ApplicationManage()
        }

        // 标准初始化方法，
        fun init(application: Application) {
            instance.init(application)
        }
    }

    // 全局上下文对象
    var application: Application? = null
    // 退出 app 工具类
    var exitmanage: ExitManage = ExitManage()
    // app 全局生命周期管理类，使用 livedata 实现，考虑其若是外部可见，就能使用他乱发射数据，数据私有
    private var lifecycleManage: LifecycleManage = LifecycleManage()
    // app 状态管理类，也是私有，这个实现绝对是不对外的，大家关心结果就好了，由 ApplicationManage 衔接
    private var stateManage: StateManage = StateManage()

    /**
     * 初始化方法私有，由静态方法衔接
     */
    private fun init(application: Application) {
        this.application = application
        lifecycleManage.init(application)
        stateManage.initStateManage(lifecycleManage)
    }



    /**
     * 添加监听
     */
    fun addObserver(tag: String? = null, lifecycle: Lifecycle? = null, observer: (lifecycleMessage: LifecycleMessage) -> Unit) {
        lifecycleManage.lifecycleLivaData.addObserver(tag, lifecycle, observer)
    }

    /**
     * 解绑
     */
    fun removeobserver(tag: String) {
        lifecycleManage.lifecycleLivaData.removeOberver(tag)
    }

    /**
     * 获取当前 app 状态
     */
    fun getCurrentState(): Int {
        return stateManage.STAET_CURRENT
    }

    /**
     * 消息类型
     */
    class MessageType {

        companion object {
            // 对应 activity 的生命周期
            @JvmField
            val MESSAGE_ACTIVITY_CREATE: Int = 11
            @JvmField
            val MESSAGE_ACTIVITY_RESUME: Int = 12
            @JvmField
            val MESSAGE_ACTIVITY_START: Int = 13
            @JvmField
            val MESSAGE_ACTIVITY_PAUSE: Int = 14
            @JvmField
            val MESSAGE_ACTIVITY_STOP: Int = 15
            @JvmField
            val MESSAGE_ACTIVITY_DESTROYED: Int = 16
            @JvmField
            val MESSAGE_ACTIVITY_SAVEINSTANCESTATE: Int = 17

            // app 启动，退出,切换到前台，切换到后台
            @JvmField
            val MESSAGE_APP_START: Int = 21
            @JvmField
            val MESSAGE_APP_EXIT: Int = 25
            @JvmField
            val MESSAGE_APP_FORNT: Int = 22
            @JvmField
            val MESSAGE_APP_BACKGROUD: Int = 23
        }
    }

}