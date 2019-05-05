package com.bloodcrown.baselib.livedata

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

/**
 * 作者 ： BloodCrown
 * 时间 ： 2019-05-05 15:58
 * 描述 ：
 * 1. 自定义的 LiveData，为了是去掉 LiveData 一些不合时宜的设定
 * 2. 自己写的才能百分百按照自己的设想去做
 *
 * 成员变量描述：
 * 1. subject 对外提供的 PublishSubject 用于热发射
 * 2. disposableList map 集合，用来存储管道对象，因为有的订阅没有页面级别的生命周期
 *
 * 功能：
 * 1. sendValue 发送数据
 * 2. addObserver 注册观察者
 *      lifecycle ！= null -> 会在注册观察者的同时，在 Lifecycle.Event.ON_DESTROY 时会解除绑定
 *      tag ！= null -> 会把管道对象保存到 map 集合里，用于自助解除注册
 */
class MyLiveData<T> : AbsMyLiveData<T>() {

    // 核心数据数据被观察者
    var subject = PublishSubject.create<T>()
    // 保存管道的 map 集合
    var disposableList: MutableMap<String, Disposable> = mutableMapOf()

    /**
     * 发送数据
     */
    override fun sendValue(data: T) {
        if (data == null) return
        setValue(data)
        subject.onNext(data)
    }

    /**
     * 注册观察者，考虑了没有页面级别的生命周期的情况
     *
     *      lifecycle ！= null -> 会在注册观察者的同时，在 Lifecycle.Event.ON_DESTROY 时会解除绑定
     *      tag ！= null -> 会把管道对象保存到 map 集合里，用于自助解除注册
     */
    fun addObserver(tag: String? = null, lifecycle: Lifecycle? = null, observer: (data: T) -> Unit) {
        var disposable = subject.subscribe {
            observer(it)
        }
        if (tag != null) disposableList.put(tag, disposable)
        if (disposable != null) lifecycle?.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun destroy() {
                if (!disposable.isDisposed) disposable.dispose()
                disposableList.remove(tag)
            }
        })
    }

    /**
     * 手动解除注册，只适用于在注册时没有传入 lifecycle 的朋友
     */
    fun removeOberver(tag: String) {
        if (tag == null) return

        var disposable = disposableList.get(tag)
        if (disposable == null) return

        if (!disposable?.isDisposed) disposable?.dispose()
        disposableList.remove(tag)
    }

    /**
     * 用于用户自行变换扩展,不过这样就不能自行解绑了，需要用户手动进行解绑操作
     */
    fun getObservable(): PublishSubject<T> {
        return subject
    }

}