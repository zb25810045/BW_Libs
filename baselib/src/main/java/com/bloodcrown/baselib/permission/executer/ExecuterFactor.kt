package com.bloodcrown.baselib.permission.executer

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/4/20 上午3:56
 * 描述 ：
 */

object ExecuterFactor {

    @JvmField
    val AND_PERMISSION = "AND_PERMISSION"

    @JvmField
    val RX_PERMISSION = "RX_PERMISSION"

    @JvmField
    val DEFAULT_EXECUTER = AND_PERMISSION

    @JvmStatic
    fun getInstance(): IPermissionExecuter {
        return getInstance(DEFAULT_EXECUTER)
    }

    @JvmStatic
    private fun getInstance(type: String): IPermissionExecuter {

        return when (type) {
            AND_PERMISSION -> AndPermissinExecuterImpl()
            DEFAULT_EXECUTER -> AndPermissinExecuterImpl()
            else -> AndPermissinExecuterImpl()
        }
    }

}
