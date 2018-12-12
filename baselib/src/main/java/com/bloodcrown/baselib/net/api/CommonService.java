package com.bloodcrown.baselib.net.api;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/12/9 下午10:46
 * 描述 ：
 */

public interface CommonService {

    @GET("{xxxUrl}")
    Observable<ResponseBody> getMethod(@Path("xxxUrl") String url, @QueryMap Map<String, String> options);

    @GET("{xxxUrl}")
    Observable<ResponseBody> getMethod(@Path("xxxUrl") String url);

    @FormUrlEncoded
    @POST("{xxxUrl}")
    Observable<ResponseBody> postMethod(@Path("xxxUrl") String url, @FieldMap Map<String, String> options);

}
