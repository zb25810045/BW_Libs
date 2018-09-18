package com.bloodcrown.basecomponents.utils

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/9/18 上午2:42
 * 描述 ：
 */
class FastClickUtils(var timeOffset: Long = 500) {

    private var lastClickTime: Long = 0

    fun isFastClick(): Boolean {
        var flag = true
        val currentClickTime = System.currentTimeMillis()
        if (currentClickTime - lastClickTime >= timeOffset) {
            flag = false
        }
        lastClickTime = currentClickTime
        return flag
    }

}