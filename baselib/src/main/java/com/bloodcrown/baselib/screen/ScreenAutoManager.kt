package com.bloodcrown.baselib.screen

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Context.WINDOW_SERVICE
import android.content.res.Resources
import android.graphics.Point
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/12/31 下午7:12
 * 描述 ： 屏幕适配，可以分别支持宽度和高度适配，但是高度适配请注意，系统提供的黄高度是含有状态栏，但是不含底部导航栏的
 */
class ScreenAutoManager {

    lateinit var application: Application
    var autoWidth: Float = 1080f
    var baseLine: Int = BASE_LINE_WIDTH

    companion object {

        var BASE_LINE_WIDTH: Int = 1
        var BASE_LINE_HRIGHT: Int = 2

        var instance: ScreenAutoManager = ScreenAutoManager()
    }

    fun init(application: Application, autoWidth: Float, baseLine: Int) {
        instance.application = application
        instance.autoWidth = autoWidth
        instance.baseLine = baseLine
        instance.resizeDisplayMetrics(application, autoWidth, baseLine)
    }

    fun isCanResize(context: Context?, baseLine: Int): Boolean {

        if (context == null) {
            return false
        }

        when (baseLine) {
            BASE_LINE_WIDTH -> {
                if (Resources.getSystem().displayMetrics.xdpi == context.resources.displayMetrics.xdpi) {
                    return true
                }
            }
            BASE_LINE_HRIGHT -> {
                if (Resources.getSystem().displayMetrics.ydpi == context.resources.displayMetrics.ydpi) {
                    return true
                }
            }
        }

        return false
    }

    fun resizeDisplayMetrics(context: Context?, autoWidth: Float, baseLine: Int) {

        if (context == null) {
            return
        }

        if (!isCanResize(context, baseLine)) {
            return
        }

        val screenPoint = Point()
        var resources = context.resources
        var displayMetricsonMiui = getMetricsOnMiui(resources)

        (context.getSystemService(WINDOW_SERVICE) as WindowManager).defaultDisplay.getSize(screenPoint)

        when (baseLine) {

            BASE_LINE_WIDTH -> {
                resources.displayMetrics.xdpi = screenPoint.x / autoWidth * 72f
                if (displayMetricsonMiui != null) {
                    resources.displayMetrics.xdpi = screenPoint.x / autoWidth * 72f
                }
            }

            BASE_LINE_HRIGHT -> {
                resources.displayMetrics.xdpi = screenPoint.y / autoWidth * 72f
                if (displayMetricsonMiui != null) {
                    resources.displayMetrics.xdpi = screenPoint.y / autoWidth * 72f
                }
            }
        }
    }

    fun getMetricsOnMiui(resources: Resources): DisplayMetrics? {
        if ("MiuiResources" == resources.javaClass.simpleName || "XResources" == resources.javaClass.simpleName) {
            try {
                val field = Resources::class.java.getDeclaredField("mTmpMetrics")
                field.isAccessible = true
                return field.get(resources) as DisplayMetrics
            } catch (e: Exception) {
                return null
            }
        }
        return null
    }

    fun cleanResize(context: Context) {

        context.resources.displayMetrics.xdpi = Resources.getSystem().displayMetrics.xdpi

        val metrics = getMetricsOnMiui(context.resources)
        metrics?.xdpi = Resources.getSystem().displayMetrics.xdpi
    }

    fun onActivityCreated(activity: Activity?) {
        //通常情况下application与activity得到的resource虽然不是一个实例，但是displayMetrics是同一个实例，只需调用一次即可
        //为了面对一些不可预计的情况以及向上兼容，分别调用一次较为保险
        resizeDisplayMetrics(application, autoWidth, baseLine)
        resizeDisplayMetrics(activity, autoWidth, baseLine)
    }

    fun onActivityStarted(activity: Activity?) {
        resizeDisplayMetrics(application, autoWidth, baseLine)
        resizeDisplayMetrics(activity, autoWidth, baseLine)
    }

    fun onActivityResumed(activity: Activity?) {
        resizeDisplayMetrics(application, autoWidth, baseLine)
        resizeDisplayMetrics(activity, autoWidth, baseLine)
    }

}