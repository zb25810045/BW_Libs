package com.bloodcrown.baselibs

import android.content.Context

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/9/10 下午8:51
 * 描述 ：
 */
class DisplayUtils {

    companion object {

        /**
         * px 转 dp
         */
        fun px2dp(context: Context, pxValue: Int): Int {
            return (pxValue / context.getResources().getDisplayMetrics().density + 0.5f).toInt()
        }

        /**
         * px 转 sp
         */
        fun px2sp(context: Context, pxValue: Int): Int {
            return (pxValue / context.getResources().getDisplayMetrics().density + 0.5f).toInt()
        }

        /**
         * dp 转 px
         */
        fun dp2px(context: Context, dipValue: Int): Int {
            return (context.getResources().getDisplayMetrics().density * dipValue + 0.5f).toInt()
        }

        /**
         * sp 转 px
         */
        fun sp2px(context: Context, spValue: Int): Int {
            return (context.getResources().getDisplayMetrics().density * spValue + 0.5f).toInt()
        }
    }

}