package com.bloodcrown.bw.customeview.taiji

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import kotlin.text.Typography.degree

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/10/30 下午5:24
 * 描述 ：
 */
class TaijiView : View {

    private var mWhitePaint: Paint = Paint()
    private var mBlackPaint: Paint = Paint()
    private var degree: Float = 0f

    @JvmOverloads
    constructor(context: Context, attributeSet: AttributeSet? = null, defAttrStyle: Int = 0)
            : super(context, attributeSet, defAttrStyle) {

        // 初始化画笔
        initPaint()
    }


    /**
     * 初始化画笔
     */
    fun initPaint() {
        mBlackPaint.strokeWidth = 0f
        mBlackPaint.color = Color.BLACK
        mBlackPaint.isAntiAlias = true
        mBlackPaint.style = Paint.Style.FILL

        mWhitePaint.strokeWidth = 0f
        mWhitePaint.color = Color.WHITE
        mWhitePaint.isAntiAlias = true
        mWhitePaint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var r: Float = (Math.min(width, height) / 2 * 0.8).toFloat()

        canvas?.translate(width / 2.toFloat(), height / 2.toFloat())
        canvas?.rotate(degree)

        // 画太极左右黑白
        canvas?.drawArc(RectF(-r, -r, r, r), -90f, 180f, true, mWhitePaint)
        canvas?.drawArc(RectF(-r, -r, r, r), 90f, 180f, true, mBlackPaint)

        // 画太极上下小半圆
        canvas?.drawCircle(0f, -r / 2.toFloat(), r / 2.toFloat(), mBlackPaint)
        canvas?.drawCircle(0f, r / 2.toFloat(), r / 2.toFloat(), mWhitePaint)

        // 画太极上下的眼
        canvas?.drawCircle(0f, -r / 2.toFloat(), r / 10.toFloat(), mWhitePaint)
        canvas?.drawCircle(0f, r / 2.toFloat(), r / 10.toFloat(), mBlackPaint)
    }

    fun setDegree(degree: Float) {
        this.degree = degree
        invalidate()
    }

}