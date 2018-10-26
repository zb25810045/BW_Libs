package com.bloodcrown.basecomponents.view.ratingbar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.bloodcrown.basecomponents.R
import com.bloodcrown.basecomponents.sdkInfo.InfoUtils
import com.bloodcrown.basecomponents.utils.UnitUtils


/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/10/24 下午4:18
 * 描述 ：
 */
class MyRatingBar : View {

    companion object {
        private var STATE_SELECT: Int = 1
        private var STATE_UNSELECT: Int = -1
        private var STATE_HALF: Int = 0
    }

    var mpaint = Paint()

    lateinit var selectDrawable: Drawable
    lateinit var unselectDrawable: Drawable
    lateinit var halfDrawable: Drawable

    // 星星默认大小 20dp
    var defaultStartSize: Int = UnitUtils.dp2px(context, 20)

    var currentStartCount: Float = 0f
    var maxStartCount: Int = 0
    var startSize: Int = 0
    var startSetp: Int = 0
    var canTouch: Boolean = true

    var startInfoList = mutableListOf<Int>()

    // 点击事件的对象函数
    lateinit var click: (rating: Float) -> Unit

    @JvmOverloads
    constructor(context: Context, attributeSet: AttributeSet? = null, defAttrStyle: Int = 0)
            : super(context, attributeSet, defAttrStyle) {

        // 初始化画笔
        initPaint()
        // 初始化默认图片资源
        initDrawable()
        // 初始化各种自定义参数
        initAttrs(context, attributeSet, defAttrStyle)
        cauculateStartState()
    }

    fun initPaint() {
        mpaint.color = Color.DKGRAY
        mpaint.strokeWidth = 1f
        mpaint.isAntiAlias = true
        mpaint.style = Paint.Style.STROKE
    }

    fun initDrawable() {

        if (InfoUtils.sdkVersion(21)) {
            selectDrawable = resources.getDrawable(R.drawable.vc_selectstar_24dp)
            unselectDrawable = resources.getDrawable(R.drawable.vc_unselectstart_24dp)
            halfDrawable = resources.getDrawable(R.drawable.vc_halfstart_24dp)
        } else {
            selectDrawable = resources.getDrawable(R.drawable.select_selectstar_24dp)
            unselectDrawable = resources.getDrawable(R.drawable.select_unselectstart_24dp)
            halfDrawable = resources.getDrawable(R.drawable.select_halfstart_24dp)
        }
    }

    /**
     * 初始化各种自定义参数
     */
    private fun initAttrs(context: Context, attributeSet: AttributeSet?, defAttrStyle: Int) {
        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MyRatingBar)
        (0..typedArray.indexCount)
                .asSequence()
                .map { typedArray.getIndex(it) }
                .forEach {
                    when (it) {
                        R.styleable.MyRatingBar_maxStarCount -> {
                            maxStartCount = typedArray.getInt(R.styleable.MyRatingBar_maxStarCount, 5)
                        }
                        R.styleable.MyRatingBar_currentStarCount -> {
                            currentStartCount = typedArray.getFloat(R.styleable.MyRatingBar_currentStarCount, 0f)
                        }
                        R.styleable.MyRatingBar_starSize -> {
                            startSize = typedArray.getDimensionPixelSize(R.styleable.MyRatingBar_starSize, defaultStartSize)
                        }
                        R.styleable.MyRatingBar_starStep -> {
                            startSetp = typedArray.getDimensionPixelSize(R.styleable.MyRatingBar_starStep, 0)
                        }
                        R.styleable.MyRatingBar_canTouch -> {
                            canTouch = typedArray.getBoolean(R.styleable.MyRatingBar_canTouch, true)
                        }
                        R.styleable.MyRatingBar_drawable_select -> {
                            selectDrawable = typedArray.getDrawable(R.styleable.MyRatingBar_drawable_select)
                        }
                        R.styleable.MyRatingBar_drawable_unSelect -> {
                            unselectDrawable = typedArray.getDrawable(R.styleable.MyRatingBar_drawable_unSelect)
                        }
                        R.styleable.MyRatingBar_drawable_halfSelect -> {
                            halfDrawable = typedArray.getDrawable(R.styleable.MyRatingBar_drawable_halfSelect)
                        }
                    }
                }
        if (maxStartCount < 0) maxStartCount = 0
        if (currentStartCount > maxStartCount) currentStartCount = maxStartCount.toFloat()

        typedArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        var widthSize = MeasureSpec.getSize(widthMeasureSpec)

        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        var heightSize = MeasureSpec.getSize(heightMeasureSpec)

        if (heightMode == MeasureSpec.AT_MOST) {
            heightSize = startSize
        }

        if (widthMode == MeasureSpec.AT_MOST) {
            widthSize = startSize * maxStartCount + startSetp * (maxStartCount - 1)
        }

        setMeasuredDimension(widthSize, heightSize)
    }

    /**
     * 计算星星的显示状态，是满星，半星，还是没有星
     */
    fun cauculateStartState() {

        startInfoList.clear()

        if (currentStartCount == 0f) {
            (1..maxStartCount).forEach { startInfoList.add(STATE_UNSELECT) }
            return
        }

        var index: Int = currentStartCount.toInt()
        if (index >= 1) (1..index).forEach { startInfoList.add(STATE_SELECT) }

        // 说明有小数位
        if (currentStartCount > index) {
            startInfoList.add(STATE_HALF)
            index += 2
        } else {
            index++
        }

        if (maxStartCount >= index) {
            (index..maxStartCount).forEach { startInfoList.add(STATE_UNSELECT) }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (startInfoList.size == 0) return

        selectDrawable.setBounds(0, 0, startSize, startSize)
        unselectDrawable.setBounds(0, 0, startSize, startSize)
        halfDrawable.setBounds(0, 0, startSize, startSize)

        canvas?.save()
        startInfoList.forEach {
            when (it) {
                STATE_SELECT -> selectDrawable.draw(canvas)
                STATE_UNSELECT -> unselectDrawable.draw(canvas)
                STATE_HALF -> halfDrawable.draw(canvas)
            }
            canvas?.translate((startSize + startSetp).toFloat(), 0f)
        }
        canvas?.restore()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if (!canTouch) return false

        if (event?.action == MotionEvent.ACTION_DOWN) {

            if (event.x >= width) {
                setRating(maxStartCount.toFloat())
                return true
            }

            var index_float: Float = event.x / (startSize + startSetp)
            var index_int: Int = index_float.toInt()

            if (index_float <= (index_int + 0.3f)) {
                setRating(index_int.toFloat())
                return true
            }

            if (index_float > (index_int + 0.3f) && index_float < (index_int + 0.7f)) {
                setRating(index_int + 0.5f)
                return true
            }

            if (index_float >= (index_int + 0.7f)) {
                setRating((index_int + 1).toFloat())
                return true
            }
        }

        return true
    }

    fun setRating(rating: Float) {
        currentStartCount = rating
        cauculateStartState()
        invalidate()
        click.invoke(currentStartCount)
    }

}