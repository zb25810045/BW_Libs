package com.bloodcrown.baselib.livedata

/**
 * 作者 ： BloodCrown
 * 时间 ： 2019-05-05 16:09
 * 描述 ： 自定义 LiveData 的抽象基类
 *
 *  1. 实现根接口，提供数据存储,获取功能
 *  2. 发送数据应该是具体实现关心的
 *
 */
abstract class AbsMyLiveData<T> : IMyLiveData<T> {

    // 数据对象
    private var mValue: T? = null

    override fun getValue(): T? {
        return mValue
    }

    override fun setValue(t: T) {
        this.mValue = t
    }
}