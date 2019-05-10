package com.bloodcrown.basecomponents.applicaton.lifecycle

import android.app.Activity
import android.os.Bundle

/**
 * 作者 ： BloodCrown
 * 时间 ： 2019-05-08 21:47
 * 描述 ：
 */
class LifecycleMessage(var type: Int, var activity: Activity? = null, var savedInstanceState: Bundle? = null) {
}