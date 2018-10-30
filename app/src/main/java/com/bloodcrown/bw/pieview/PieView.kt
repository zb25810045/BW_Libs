package com.bloodcrown.bw.pieview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/10/29 下午10:44
 * 描述 ：
 */
class PieView : View {

    private var mPaint: Paint = Paint()
    var startAngle: Float = 0f
    var mData = mutableListOf<Float>()
    var mColor = mutableListOf(0xffccff00, 0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00)

    @JvmOverloads
    constructor(context: Context, attributeSet: AttributeSet? = null, defAttrStyle: Int = 0)
            : super(context, attributeSet, defAttrStyle) {

        // 初始化画笔
        initPaint()
    }

    fun initPaint() {
        mPaint.strokeWidth = 0f
        mPaint.color = Color.BLACK
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (mData.size == 0) return

        canvas?.translate(width / 2.toFloat(), height / 2.toFloat())

        // 饼状图半径
        val r = (Math.min(width, height) / 2 * 0.8).toFloat()
        val rect = RectF(-r, -r, r, r)


        var currentAngle: Float = startAngle

        for ((index, value) in mData.withIndex()) {

            mPaint.color = mColor.get(index).toInt()

            if (index == mData.size - 1) {
                canvas?.drawArc(rect, currentAngle, startAngle + 360 - currentAngle, true, mPaint)
                return
            }

            canvas?.drawArc(rect, currentAngle, 360 * value, true, mPaint)
            currentAngle += 360 * value
        }

    }

    fun setData(data: MutableList<Float>?) {

        mData.clear()

        var total: Float = 0f
        data?.forEach { total += it }
        data?.forEach { mData.add(it / total) }

        postInvalidate()
    }

}