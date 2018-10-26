package com.bloodcrown.basecomponents.sdkInfo

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/9/18 下午11:46
 * 描述 ：
 */
class InfoUtils {

    companion object {

        /**
         * 判断 SDK 版本大小
         */
        fun sdkVersion(version: Int): Boolean {
            if (getSdkVersion() >= version) {
                return true
            }
            return false
        }

        /**
         * 获取 SDK 版本号
         */
        fun getSdkVersion(): Int {
            return android.os.Build.VERSION.SDK_INT
        }

    }

}