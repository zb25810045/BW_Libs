package com.bloodcrown.basecomponents.utils

import android.content.Context

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/9/29 下午5:52
 * 描述 ： 屏幕工具
 */
class ScreenUtils {

    companion object {

        /**
         * 获取屏幕宽度
         */
        fun getScreenWidth(context: Context): Int {
            return context.getResources().getDisplayMetrics().widthPixels
        }

        /**
         * 获取屏幕高度
         */
        fun getScreenHeight(context: Context): Int {
            return context.getResources().getDisplayMetrics().heightPixels
        }

    }


}