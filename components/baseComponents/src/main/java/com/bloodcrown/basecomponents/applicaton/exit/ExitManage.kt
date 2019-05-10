package com.bloodcrown.basecomponents.applicaton.exit

import android.app.Activity
import android.content.Intent
import com.bloodcrown.basecomponents.applicaton.ApplicationManage

/**
 * 作者 ： BloodCrown
 * 时间 ： 2019-05-09 19:09
 * 描述 ：
 */
class ExitManage {

    fun exitApp(): Boolean {
        if (ApplicationManage.instance.application == null) return false

        var intent = Intent(ApplicationManage.instance.application, ExitActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        ApplicationManage.instance.application?.startActivity(intent)
        return true
    }

    fun exitAppBySystem() {
        System.exit(0)
    }

    fun startActivityProxy(activity: Activity, intentYou: Intent) {
        if (activity == null) return

        var intentExit = Intent(activity, ExitActivity::class.java)
        intentExit.putExtra(ExitMessage.MESSAGE_ACTION, ExitMessage.ACTION_EXIT)

        activity.startActivity(intentExit)
        activity.startActivity(intentYou)
    }

}