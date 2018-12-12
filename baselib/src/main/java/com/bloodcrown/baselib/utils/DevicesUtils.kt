package values

import android.content.Context
import android.telephony.TelephonyManager

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/12/9 下午4:08
 * 描述 ： 设备工具
 *
 * 实现功能：
 * 1. 获取设备_IMEI-> getDevicesID
 * 2. 获取版本名称-> getVersionName
 * 3. 获取版本号-> getVersionCode
 */
class DevicesUtils {

    companion object {

        /**
         * 获取设备_IMEI
         *
         * @param context 上下文
         */
        fun getDevicesID(context: Context?): String {
            if (null == context) {
                return ""
            }
            val telephoneManage = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            return telephoneManage.deviceId
        }

        /**
         * 获取版本名称
         *
         * @param context 上下文
         * @return
         */
        fun getVersionName(context: Context): String {
            try {
                val pm = context.packageManager
                val packageInfo = pm.getPackageInfo(context.packageName, 0)
                return packageInfo.versionName
            } catch (e: Exception) {
//                DebugLog.e(ContentValues.TAG, "getMyVersionName()", e)
            }
            return ""
        }

        /**
         * 获取版本号
         *
         * @param context 上下文
         * @return
         */
        fun getVersionCode(context: Context): Int {
            try {
                val pm = context.packageManager
                val packageInfo = pm.getPackageInfo(context.packageName, 0)
                return packageInfo.versionCode
            } catch (e: Exception) {
//                DebugLog.e(ContentValues.TAG, "getMyVersionCode()", e)
            }
            return 0
        }

    }


}