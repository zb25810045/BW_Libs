package com.bloodcrown.baselib.net.exception;

import org.json.JSONException;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/12/11 下午8:48
 * 描述 ：
 */

public class ApiException extends Exception {

    public static String getErrorInfo(Throwable throwable) {
        if (throwable instanceof ApiException) {
            return throwable.getMessage();
        }
        if (throwable instanceof JSONException) {
            return "数据异常";
        }
        return "网络或服务器异常";
    }

    public ApiException(String message) {
        super(message);
    }
}
