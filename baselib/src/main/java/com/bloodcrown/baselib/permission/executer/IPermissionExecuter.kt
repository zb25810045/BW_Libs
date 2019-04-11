package com.bloodcrown.baselib.permission.executer

import com.bloodcrown.baselib.permission.config.PermissionConfig

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/4/19 下午12:23
 * 描述 ： 权限请求执行器，这是实际对于不同的权限库的封装
 */

interface IPermissionExecuter {

    fun run(permissionConfig: PermissionConfig)

}
