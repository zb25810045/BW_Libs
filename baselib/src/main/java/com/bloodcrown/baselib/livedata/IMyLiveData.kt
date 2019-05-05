package com.bloodcrown.baselib.livedata

/**
 * 作者 ： BloodCrown
 * 时间 ： 2019-05-05 16:03
 * 描述 ： 自定义 LiveData 跟接口
 *
 *  1. 提供获取设置数据的接口
 *  2. 发送数据的接口
 */
interface IMyLiveData<T> {

    /**
     * 获取数据
     */
    fun getValue(): T?

    /**
     * 设置数据
     */
    fun setValue(t: T)

    /**
     * 发送
     */
    fun sendValue(t: T)
}