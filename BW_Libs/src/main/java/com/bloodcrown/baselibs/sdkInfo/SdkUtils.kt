package com.bloodcrown.baselibs.sdkInfo

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/9/18 下午11:46
 * 描述 ：
 */
class AndroidInfoUtils {

    companion object {

        /**
         * 判断 SDK 版本大小
         */
        fun isUpSdkVersion(version: Int): Boolean {
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