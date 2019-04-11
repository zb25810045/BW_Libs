package com.bloodcrown.baselib.permission.config

import android.content.Context
import com.bloodcrown.baselib.permission.executer.ExecuterFactor

/**
 * 作者 ： BloodCrown
 * 时间 ： 2019/4/9 下午9:51
 * 描述 ：
 */
class PermissionConfig {

    lateinit var context: Context
    // 权限申请成功时回调
    var onSuccessAction: () -> Unit = {}
    // 权限申请失败时回调
    var onDenialAction: () -> Unit = {}
    // 用户设置不显示权限申请弹窗时回调
    var onDontShowAction: () -> Unit = {}
    // 权限集合
    var permissions = mutableListOf<String>()

    private var type: String = ExecuterFactor.DEFAULT_EXECUTER

    /**
     * 添加权限
     */
    fun addPermission(permission: String) {
        if (!permission.isEmpty()) permissions.add(permission)
    }

    /**
     * 设置类型
     */
    fun setType(type: String): PermissionConfig {
        if (!type.isEmpty()) this.type = type
        return this
    }

    /**
     * 执行操作
     */
    fun run() {
        ExecuterFactor.getInstance().run(this)
    }


}