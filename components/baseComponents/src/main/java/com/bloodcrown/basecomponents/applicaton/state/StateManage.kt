package com.bloodcrown.basecomponents.applicaton.state

import com.bloodcrown.basecomponents.applicaton.ApplicationManage
import com.bloodcrown.basecomponents.applicaton.lifecycle.LifecycleManage
import com.bloodcrown.basecomponents.applicaton.lifecycle.LifecycleMessage

/**
 * 作者 ： BloodCrown
 * 时间 ： 2019-05-09 21:32
 * 描述 ：
 */
class StateManage {

    companion object stateType {

        // 没启动，前台，后台
        @JvmField
        val STATE_APP_NO: Int = 31
        @JvmField
        val STATE_APP_FORNT: Int = 32
        @JvmField
        val STATE_APP_BACKGROUD: Int = 33
    }

    var STAET_CURRENT: Int = STATE_APP_NO
    var aliveActivitys: Int = 0

    fun initStateManage(lifecycleManage: LifecycleManage) {
        if (lifecycleManage == null) return

        addObserver(lifecycleManage)
    }

    /**
     * 添加管理器
     */
    private fun addObserver(lifecycleManage: LifecycleManage) {
        if (lifecycleManage == null) return
        lifecycleManage.lifecycleLivaData.addObserver {
            when (it.type) {
                ApplicationManage.MessageType.MESSAGE_ACTIVITY_CREATE -> {
                    // 标记是没启动，那么触发 create 一定是app 启动
                    if (STAET_CURRENT == STATE_APP_NO) {
                        STAET_CURRENT = STATE_APP_FORNT
                        lifecycleManage.lifecycleLivaData.sendValue(LifecycleMessage(ApplicationManage.MessageType.MESSAGE_APP_START))
                    }
                }

                ApplicationManage.MessageType.MESSAGE_ACTIVITY_START -> {
                    // 活动 ac 数量为0，并且当前标记是 app 在后台，那么此时触发 start，那么就是切会到前台来了
                    if (aliveActivitys == 0 && STAET_CURRENT == STATE_APP_BACKGROUD) {
                        STAET_CURRENT = STATE_APP_FORNT
                        lifecycleManage.lifecycleLivaData.sendValue(LifecycleMessage(ApplicationManage.MessageType.MESSAGE_APP_FORNT))
                    }
                    aliveActivitys++
                }

                ApplicationManage.MessageType.MESSAGE_ACTIVITY_STOP -> {
                    aliveActivitys--
                    if (aliveActivitys == 0 && STAET_CURRENT == STATE_APP_FORNT) {
                        STAET_CURRENT = STATE_APP_BACKGROUD
                        lifecycleManage.lifecycleLivaData.sendValue(LifecycleMessage(ApplicationManage.MessageType.MESSAGE_APP_BACKGROUD))
                    }
                }

                ApplicationManage.MessageType.MESSAGE_ACTIVITY_DESTROYED -> {
                    if (aliveActivitys == 0) {
                        STAET_CURRENT = STATE_APP_NO
                        lifecycleManage.lifecycleLivaData.sendValue(LifecycleMessage(ApplicationManage.MessageType.MESSAGE_APP_EXIT))
                    }
                }
            }
        }
    }

}