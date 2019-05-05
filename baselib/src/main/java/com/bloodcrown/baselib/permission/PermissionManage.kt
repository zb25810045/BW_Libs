package com.bloodcrown.baselib.permission

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat
import com.bloodcrown.baselib.permission.build.PermissionBuild

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/4/19 下午12:44
 * 描述 ： 权限管理的最外层API
 */

class PermissionManage {

    /**
     * 提供相关静态入口，效仿 Glide 通过 with 绑定上下文
     *
     */
    companion object {

        @JvmStatic
        fun with(context: Context): PermissionBuild {
            return PermissionBuild(context)
        }

        @JvmStatic
        fun isHavePermission(context: Context, permission: String): Boolean {
            return PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(context, permission)
        }

        @JvmStatic
        fun isHavePermissions(context: Context, permissions: List<String>): Boolean {
            for (it in permissions) {
                if (!(PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(context, it))) return false
            }
            return true
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun aaa() {

    }

}
