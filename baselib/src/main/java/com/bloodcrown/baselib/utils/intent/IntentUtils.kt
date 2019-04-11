package com.bloodcrown.baselib.utils.intent

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import com.bloodcrown.baselib.utils.build.DeviceType
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 作者 ： BloodCrown
 * 时间 ： 2019/4/11 下午12:44
 * 描述 ：
 */
class IntentUtils {

    companion object {

        @JvmStatic
        fun startSettingActivity(context: Context) {

            var productName: String = Build.MANUFACTURER
            when (productName) {
                DeviceType.HUAWEI -> startSettingActivityByHuaWei(context)
                DeviceType.MEIZU -> startSettingActivityByMeizu(context)
                DeviceType.XIAOMI -> startSettingActivityByXiaomi(context)
                DeviceType.SONY -> startSettingActivityBySony(context)
                else -> startDefaultSettingActivity(context)
            }
        }

        @JvmStatic
        fun startSettingActivityForResult(activity: Activity, code: Int) {

            var productName: String = Build.MANUFACTURER
            when (productName) {
                DeviceType.HUAWEI -> startSettingActivityForResultByHuaWei(activity, code)
                DeviceType.MEIZU -> startSettingActivityForResultByMeizu(activity, code)
                DeviceType.XIAOMI -> startSettingActivityForResultByXiaomi(activity, code)
                DeviceType.SONY -> startSettingActivityForResultBySony(activity, code)
                else -> startDefaultSettingActivityForResult(activity, code)
            }
        }

        @JvmStatic
        private fun startSettingActivityBySony(context: Context) {

            try {
                var intent = Intent(context.packageName)
                var componentName = ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity")
                intent.setComponent(componentName)
                if (!(context is Activity)) intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            } catch (e: RuntimeException) {
                startDefaultSettingActivity(context)
            }
        }

        @JvmStatic
        private fun startSettingActivityForResultBySony(activity: Activity, code: Int) {

            try {
                var intent = Intent(activity.packageName)
                var componentName = ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity")
                intent.setComponent(componentName)
                activity.startActivityForResult(intent, code)
            } catch (e: RuntimeException) {
                startDefaultSettingActivityForResult(activity, code)
            }
        }

        @JvmStatic
        private fun startSettingActivityByHuaWei(context: Context) {
            try {
                var intent = Intent(context.packageName)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                var componentName = ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity")
                intent.setComponent(componentName)
                context.startActivity(intent)
            } catch (e: RuntimeException) {
                return startDefaultSettingActivity(context)
            }
        }

        @JvmStatic
        private fun startSettingActivityForResultByHuaWei(activity: Activity, code: Int) {
            try {
                var intent = Intent(activity.packageName)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                var componentName = ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity")
                intent.setComponent(componentName)
                activity.startActivityForResult(intent, code)
            } catch (e: RuntimeException) {
                startDefaultSettingActivityForResult(activity, code)
            }
        }

        @JvmStatic
        private fun startSettingActivityByXiaomi(context: Context) {

            val miuiVersion = getMiuiVersion()
            var intent = Intent()
            if ("V6".equals(miuiVersion) || "V7".equals(miuiVersion)) {
                intent.setAction("miui.intent.action.APP_PERM_EDITOR")
                intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity")
                intent.putExtra("extra_pkgname", context.packageName)
                if (!(context is Activity)) intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
                return
            } else if ("V8".equals(miuiVersion) || "V9".equals(miuiVersion)) {
                intent.setAction("miui.intent.action.APP_PERM_EDITOR")
                intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity")
                intent.putExtra("extra_pkgname", context.packageName)
                if (!(context is Activity)) intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
                return
            } else {
                startDefaultSettingActivity(context)
            }
        }

        @JvmStatic
        private fun startSettingActivityForResultByXiaomi(activity: Activity, code: Int) {

            val miuiVersion = getMiuiVersion()
            var intent = Intent()
            if ("V6".equals(miuiVersion) || "V7".equals(miuiVersion)) {
                intent.setAction("miui.intent.action.APP_PERM_EDITOR")
                intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity")
                intent.putExtra("extra_pkgname", activity.packageName)
                activity.startActivityForResult(intent, code)
                return
            } else if ("V8".equals(miuiVersion) || "V9".equals(miuiVersion)) {
                intent.setAction("miui.intent.action.APP_PERM_EDITOR")
                intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity")
                intent.putExtra("extra_pkgname", activity.packageName)
                activity.startActivityForResult(intent, code)
                return
            } else {
                startDefaultSettingActivityForResult(activity, code)
            }
        }

        @JvmStatic
        private fun getMiuiVersion(): String {

            var propName = "ro.miui.ui.version.name"
            var line = ""
            var input: BufferedReader? = null

            try {
                var p = Runtime.getRuntime().exec("getprop$propName")
                input = BufferedReader(InputStreamReader(p.getInputStream()), 1024)
                line = input.readLine()
            } catch (e: RuntimeException) {
            } finally {
                try {
                    input?.close()
                    return line
                } catch (e: RuntimeException) {
                    return line
                }
            }
        }

        @JvmStatic
        private fun startSettingActivityByMeizu(context: Context) {
            try {
                var intent = Intent("com.meizu.safe.security.SHOW_APPSEC")
                intent.addCategory(Intent.CATEGORY_DEFAULT)
                intent.putExtra("packageName", context.packageName)
                if (!(context is Activity)) intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            } catch (e: RuntimeException) {
                startDefaultSettingActivity(context)
            }
        }

        @JvmStatic
        private fun startSettingActivityForResultByMeizu(activity: Activity, code: Int) {
            try {
                var intent = Intent("com.meizu.safe.security.SHOW_APPSEC")
                intent.addCategory(Intent.CATEGORY_DEFAULT)
                intent.putExtra("packageName", activity.packageName)
                activity.startActivityForResult(intent, code)
            } catch (e: RuntimeException) {
                startDefaultSettingActivityForResult(activity, code)
            }
        }

        @JvmStatic
        private fun startDefaultSettingActivity(context: Context) {

            var intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            var uri = Uri.fromParts("package", context.packageName, null)
            intent.setData(uri)
            if (!(context is Activity)) intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }

        @JvmStatic
        private fun startDefaultSettingActivityForResult(activity: Activity, code: Int) {

            var intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            var uri = Uri.fromParts("package", activity.packageName, null)
            intent.setData(uri)
            activity.startActivityForResult(intent, code)
        }


    }
}
