package com.bloodcrown.repositroy.common;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

public class CommonHttpFunctionByBaseResponse<T> implements Function<BaseResponse<T>, T> {

    @Override
    public T apply(BaseResponse<T> baseResponse) throws Exception {

        if (!baseResponse.isSuccess()) {
            // 有特殊处理，可以在这里进行，比如 T 票，并不是所有的接口都要相应 Token 被 T 的问题
            // 这里在具体的 response 类里自行判断是不是要添加处理，也是为了灵活一些
            Observable.error(new Exception(baseResponse.getMessage()));
        }
        return baseResponse.getData();
    }
}
