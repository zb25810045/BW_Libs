package com.bloodcrown.baselib.utils

import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/12/27 下午11:19
 * 描述 ： 系统状态栏工具
 *
 * 1. 修改 4.4 系统状态栏颜色 -> setStatusBarColorByKITKAT
 * 2. 获取系统状态栏高度 -> getStatusBarHeight
 */
class StatusBarUtils {

    companion object {

        /**
         * 修改 4.4 系统状态栏颜色
         */
        fun setStatusBarColorByKITKAT(window: Window, context: Context, color: Int) {

            if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                var systemContent = window.findViewById(android.R.id.content) as ViewGroup

                var statusBarView = View(context)
                var lp = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(context))
                statusBarView.setBackgroundColor(color)

                systemContent.getChildAt(0).setFitsSystemWindows(true);
                systemContent.addView(statusBarView, 0, lp);
            }
        }

        /**
         * 获取系统状态栏高度
         */
        fun getStatusBarHeight(context: Context): Int {
            var result: Int = 0
            var resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                result = context.getResources().getDimensionPixelSize(resourceId)
            }
            return result;
        }
    }


}