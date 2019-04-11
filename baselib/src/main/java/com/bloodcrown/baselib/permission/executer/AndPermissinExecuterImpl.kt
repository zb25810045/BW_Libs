package com.bloodcrown.baselib.permission.executer

import com.bloodcrown.baselib.permission.config.PermissionConfig
import com.yanzhenjie.permission.AndPermission

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/4/19 下午12:22
 * 描述 ：
 */

class AndPermissinExecuterImpl : IPermissionExecuter {

    override fun run(permissionConfig: PermissionConfig) {
        AndPermission.with(permissionConfig.context)
                .permission(permissionConfig.permissions.toTypedArray())
                // 用户给权限了
                .onGranted({ permissions: List<String> -> permissionConfig.onSuccessAction() })
                // 用户拒绝权限，包括不再显示权限弹窗也在此列
                .onDenied({ permissions: List<String> ->
                    // 判断用户是不是不再显示权限弹窗了，若不再显示的话进入权限设置页
                    if (AndPermission.hasAlwaysDeniedPermission(permissionConfig.context, permissions)) {
                        // 打开权限设置页
                        permissionConfig.onDontShowAction()
                        return@onDenied
                    }
                    permissionConfig.onDenialAction()
                })
                .start()
    }
}
