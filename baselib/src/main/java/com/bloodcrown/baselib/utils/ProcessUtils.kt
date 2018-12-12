import android.app.ActivityManager
import android.content.Context

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/12/9 下午3:58
 * 描述 ： 进程工具
 *
 * 实现功能：
 * 1. 获取进程名称 -> getCurProcessName
 */
class ProcessUtils {

    companion object {

        /**
         * 获取进程名字
         */
        fun getCurProcessName(context: Context): String {
            var result: String = ""
            val pid = android.os.Process.myPid()
            val mActivityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            mActivityManager.runningAppProcesses.forEach {
                it.pid = pid
                return it.processName
            }
            return result
        }

    }

}