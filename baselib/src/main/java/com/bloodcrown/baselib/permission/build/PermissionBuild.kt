package com.bloodcrown.baselib.permission.build

import android.content.Context
import com.bloodcrown.baselib.permission.config.PermissionConfig

/**
 * 作者 ： BloodCrown
 * 时间 ： 2019/4/9 下午10:15
 * 描述 ：
 */
class PermissionBuild(var context: Context) {

    var permissionConfig: PermissionConfig = PermissionConfig()

    init {
        permissionConfig.context = this.context
    }

    /**
     * 设置类型
     */
    fun type(type: String): PermissionBuild {
        if (!type.isEmpty()) permissionConfig.setType(type)
        return this
    }

    /**
     * 添加权限
     */
    fun permission(permission: String): PermissionBuild {
        if (!permission.isEmpty()) permissionConfig?.addPermission(permission)
        return this
    }

    /**
     * 添加成功操作
     */
    fun onSuccess(onSuccessAction: () -> Unit): PermissionBuild {
        if (onSuccessAction != null) permissionConfig.onSuccessAction = onSuccessAction
        return this
    }

    /**
     * 添加失败操作
     */
    fun onDenial(onDenialAction: () -> Unit): PermissionBuild {
        if (onDenialAction != null) permissionConfig.onDenialAction = onDenialAction
        return this
    }

    /**
     * 添加不显示权限弹窗操作
     */
    fun onDontShow(onDontShowAction: () -> Unit): PermissionBuild {
        if (onDontShowAction != null) permissionConfig.onDontShowAction = onDontShowAction
        return this
    }

    /**
     * 执行操作
     */
    fun run() {
        permissionConfig.run()
    }
}