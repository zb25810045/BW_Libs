package com.bloodcrown.basecomponents.utils

import android.content.Context
import android.util.TypedValue

/**
 * 作者 ： BloodCrown
 *
 * 时间 ： 2018/9/10 下午8:51
 * 描述 ：
 *          TypedValue.applyDimension()方法的功能就是把非标准尺寸转换成标准尺寸, 如: 
dp->px:  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, context.getResources().getDisplayMetrics());
in->px: TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_IN, 20, context.getResources().getDisplayMetrics());
mm->px: TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_MM, 20, context.getResources().getDisplayMetrics());
pt->px: TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PT, 20, context.getResources().getDisplayMetrics());
sp->px: TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, context.getResources().getDisplayMetrics());
 */
class UnitUtils {

    companion object {

        /**
         * 获取屏幕密度
         */
        fun px2dp(context: Context): Float {
            return context.getResources().getDisplayMetrics().density
        }


        /**
         * dp 转 px
         */
        fun dp2px(context: Context, dipValue: Int): Int {
            return (context.getResources().getDisplayMetrics().density * dipValue + 0.5f).toInt()
        }

        /**
         * dp 转 px
         */
        fun dp2px(context: Context, dipValue: Float): Int {
            return (context.getResources().getDisplayMetrics().density * dipValue).toInt()
        }

        /**
         * px 转 dp
         */
        fun px2dp(context: Context, pxValue: Int): Int {
            return (pxValue / context.getResources().getDisplayMetrics().density + 0.5f).toInt()
        }

        /**
         * sp 转 px
         */
        fun sp2px(context: Context, spValue: Int): Int {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue.toFloat(), context.getResources().getDisplayMetrics()).toInt()
        }
    }

}