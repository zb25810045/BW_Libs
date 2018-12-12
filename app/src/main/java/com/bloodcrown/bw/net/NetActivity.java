package com.bloodcrown.bw.net;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bloodcrown.basecomponents.toast.ToastComponent;
import com.bloodcrown.baselib.net.exception.ApiException;
import com.bloodcrown.bw.R;
import com.bloodcrown.repositroy.book.BookRepositroy;
import com.bloodcrown.repositroy.book.BookResponse;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class NetActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.view_recy);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        LinearLayoutManager layoutManage = new LinearLayoutManager(this);
        layoutManage.setOrientation(LinearLayoutManager.VERTICAL);
        BookAdapter adapter = new BookAdapter();

        recyclerView.setLayoutManager(layoutManage);
        recyclerView.setAdapter(adapter);

        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                Disposable disposable = new BookRepositroy()
                        .get("人生", "", "0", "10")
                        .subscribe(
                                new Consumer<BookResponse>() {
                                    @Override
                                    public void accept(BookResponse bookResponse) throws Exception {
                                        List<BookResponse.Book> books = bookResponse.getBooks();
                                        if (books != null && books.size() == 0) {
                                            ToastComponent.Companion.getInstance().show("没有数据", Toast.LENGTH_SHORT);
                                        }
                                        adapter.refreshData(books);
                                    }
                                },
                                new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {
                                        // ApiException.getErrorInfo(throwable) 获取统一错误信息
                                        ToastComponent.Companion.getInstance().show(ApiException.getErrorInfo(throwable), Toast.LENGTH_SHORT);
                                        Log.d("AA", "错误:" + ApiException.getErrorInfo(throwable));
                                    }
                                }
                        );
            }
        });

    }

}
