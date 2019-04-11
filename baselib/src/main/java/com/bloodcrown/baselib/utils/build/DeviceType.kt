package com.bloodcrown.baselib.utils.build

/**
 * 作者 ： BloodCrown
 * 时间 ： 2019/4/11 下午2:14
 * 描述 ： 设备厂商 Build 识别码 = Build.HARDWARE(硬件厂商) / Build.BRAND(系统定制商)
 */
class DeviceType {

    companion object {

        @JvmField
        val HUAWEI: String = "HUAWEI"

        @JvmField
        val VIVO: String = "vivo"

        @JvmField
        val OPPO: String = "OPPO"

        @JvmField
        val COOLPAD: String = "Coolpad"

        @JvmField
        val MEIZU: String = "Meizu"

        @JvmField
        val XIAOMI: String = "Xiaomi"

        @JvmField
        val SAMSUNG: String = "samsung"

        @JvmField
        val SONY: String = "Sony"

        @JvmField
        val LG: String = "LG"
    }
}