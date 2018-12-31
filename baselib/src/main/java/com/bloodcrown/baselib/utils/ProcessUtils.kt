import android.app.ActivityManager
import android.content.Context

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/12/9 下午3:58
 * 描述 ： 进程工具
 *
 * 实现功能：
 * 1. 判断当前进程是不是主进程 -> isMainProcess
 * 2. 获取进程名称 -> getProcessName
 *
 *
 * 相关代码：
 * 1. 获取当前进程 id
 *  -> val pid = android.os.Process.myPid()
 *
 *
 */
class ProcessUtils {

    companion object {

        /**
         * 判断当前进程是不是主进程
         */
        fun isMainProcess(context: Context, mainProcessName: String, pid: Int): Boolean {
            return mainProcessName?.equals(getProcessName(context, pid))
        }

        /**
         * 获取进程名字
         */
        fun getProcessName(context: Context, pid: Int): String {

            var result: String = ""
            val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

            if (activityManager == null) {
                return ""
            }

            activityManager.runningAppProcesses.forEach {
                it.pid = pid
                return it.processName
            }
            return result
        }

    }
}