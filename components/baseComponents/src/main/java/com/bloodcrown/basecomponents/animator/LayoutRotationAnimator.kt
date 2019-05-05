package com.bloodcrown.basecomponents.animator

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.View

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/9/15 下午11:27
 * 描述 ：
 */
class LayoutRotationAnimator(view: View, time: Long = 300) {

    /**
     * 画面切换时显示监听器
     */
    interface IStateChangeListener {

        fun showA()

        fun showB()
    }

    // A面 = 正面
    var STATE_A: Int = 1
    // B面 = 反面
    var STATE_B: Int = -1
    // 当前在哪面
    var currentState: Int = STATE_A

    // A 面动画
    var animatorA: ObjectAnimator
    // B 面动画
    var animatorB: ObjectAnimator

    // 面切换时显示变化
    lateinit var stateChangeListener: IStateChangeListener

    init {

        animatorA = ObjectAnimator.ofFloat(view, "rotationY", 0f, 90f).setDuration(time)
        animatorB = ObjectAnimator.ofFloat(view, "rotationY", -90f, 0f).setDuration(time)

        animatorA.addListener(object : Animator.AnimatorListener {

            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                view.rotationY = 0f
                changeState()
                animatorB.start()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })
    }

    fun start() {
        animatorA.start()
    }

    /**
     * 画面更新时切换显示
     */
    private fun changeState() {
        if (currentState == STATE_A) {
            currentState = STATE_B
            stateChangeListener.showB()
        } else {
            currentState = STATE_A
            stateChangeListener.showA()
        }
    }

}