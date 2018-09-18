package com.bloodcrown.basecomponents.animator

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Build
import android.view.MotionEvent
import android.view.View
import android.view.animation.OvershootInterpolator
import com.bloodcrown.basecomponents.utils.FastClickUtils

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/9/17 下午9:58
 * 描述 ：
 */
class LayoutClickAnimator(var view: View, var time: Long = 300) {

    // view 大小缩放的量，注意不是最终值
    var scaleOffset: Float = 0.05f

    // view 初始的 Z 轴高度值
    var transitionZ: Float = 0f
    // view 按下时 Z 轴最终值
    var transitionZEnd: Float = 0f

    // 按下动画和回弹动画的进行时标记
    var isDowning: Boolean = false
    var isUping: Boolean = false

    // 连点判断工具
    var fastClickUtils = FastClickUtils(time)

    /**
     * 主构造函数内初始化参数，给指定 view 添加触摸监听
     */
    init {
        initParameter()
        addTouchListener()
    }

    /**
     * 初始化参数
     * 这里是在 5.0 时获取 Z 轴的高度
     */
    private fun initParameter() {

        /**
         * 大于 21 要添加阴影的动画
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            transitionZ = view.translationZ
        }
    }

    /**
     * 给指定 view 添加触摸监听
     * 1. 这里的思路是模拟自然，我们按下时开始收缩动画，手不松开时，回弹动画是是不会指定的，所以我们需要分别处理 ACTION_DOWN 和 ACTION_UP，
     * 所以这里我们需要2个动画集合
     * 2. 我试过把动画都写在一个动画集合中，会掉帧，实际效果不理想，虽然只掉了 2 帧
     * 3. 因为考虑要适配所有的 view ，传入的 view 有可能是 layoutGroup 类型的，因为不想写专门的 view ，所以只能添加 addTouchListener ，
     * 直接消费掉事件 return true，要不 ACTION_UP 不会相应的，事件会回传给更上层 view
     * 4. 使用 2 个标记分别标记缩放动画和回弹动画，是为了处理测试让人讨厌的连续点击，因为是2个动画，一个完整的点击会触发 ACTION_DOWN 和 ACTION_UP 2个事件，
     * 所以这里单单使用按钮的防止重复点击的策略就不够了
     * 5. 多加一个逻辑维度，逻辑复杂性立马就提升很多，所以能简单还是要写的简单
     */
    private fun addTouchListener() {
        view.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                val action = event?.action
                if (action == MotionEvent.ACTION_DOWN && !fastClickUtils.isFastClick() && !isDowning && !isUping) {
                    startAnimartorDown()
                }
                if ((action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) && !isUping) {
                    startAnimartorUp()
                    view.callOnClick()
                }
                return true
            }
        })
    }

    /**
     * 按下时缩放动画
     */
    private fun startAnimartorDown() {

        var animatorSet = AnimatorSet()
        animatorSet.setDuration(time)
        animatorSet.interpolator =  OvershootInterpolator(3f)

        val animatorX = ObjectAnimator.ofFloat(view, "scaleX", 1f, (1 - scaleOffset))
        val animatorY = ObjectAnimator.ofFloat(view, "scaleY", 1f, (1 - scaleOffset))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val animatorZ = ObjectAnimator.ofFloat(view, "translationZ", transitionZ, transitionZEnd)
            animatorSet.playTogether(animatorX, animatorY, animatorZ)
        } else {
            animatorSet.playTogether(animatorX, animatorY)
        }

        animatorSet.addListener(object : AnimatorListenerAdapter() {

            override fun onAnimationStart(animation: Animator?) {
                isDowning = true
            }

            override fun onAnimationEnd(animation: Animator?) {
                isDowning = false
            }
        })

        animatorSet.start()
    }

    /**
     * 手松开时回弹动画
     */
    private fun startAnimartorUp() {

        var animatorSet = AnimatorSet()
        animatorSet.setDuration(time)
        animatorSet.interpolator = OvershootInterpolator(3f)

        val animatorX = ObjectAnimator.ofFloat(view, "scaleX", (1 - scaleOffset), 1f)
        val animatorY = ObjectAnimator.ofFloat(view, "scaleY", (1 - scaleOffset), 1f)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val animatorZ = ObjectAnimator.ofFloat(view, "translationZ", transitionZEnd, transitionZ)
            animatorSet.playTogether(animatorX, animatorY, animatorZ)
        } else {
            animatorSet.playTogether(animatorX, animatorY)
        }

        animatorSet.addListener(object : AnimatorListenerAdapter() {

            override fun onAnimationStart(animation: Animator?) {
                isUping = true
            }

            override fun onAnimationEnd(animation: Animator?) {
                isUping = false
            }
        })

        animatorSet.start()
    }

}