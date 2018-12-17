package com.bloodcrown.repositroy.book;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BlueService {
    @GET("book/search")
    Observable<BookResponse> getSearchBooks(@Query("q") String name,
                                            @Query("tag") String tag, @Query("start") int start,
                                            @Query("count") int count);
}