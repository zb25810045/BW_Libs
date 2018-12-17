package com.bloodcrown.repositroy.book;

import com.bloodcrown.baselib.net.HttpManager;
import com.bloodcrown.baselib.net.exception.ApiException;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/12/10 下午8:22
 * 描述 ：
 */

public class BookRepositroy {

    public static final String URL_BOOK_LIST = "book/search";

    public Observable<BookResponse> get(String title, String tag, String startCount, String wantCount) {

        Map<String, String> map = new HashMap<>();
        map.put("q", title);
        map.put("tag", tag);
        map.put("start", startCount);
        map.put("count", wantCount);

        return HttpManager.Companion.getInstance().get(URL_BOOK_LIST, map)
                .map(new Function<ResponseBody, BookResponse>() {
                    @Override
                    public BookResponse apply(ResponseBody responseBody) throws Exception {
                        BookResponse bookResponse = null;
                        try {
                            bookResponse = new Gson().fromJson(responseBody.string(), BookResponse.class);
                        } catch (Exception e) {
                            Observable.error(new ApiException("数据异常"));
                        }
                        return bookResponse;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());
    }
}
