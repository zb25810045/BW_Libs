package com.bloodcrown.bw.customeview.textview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.bloodcrown.bw.R

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/10/11 下午10:49
 * 描述 ：
 */
class CustomeTextView : View {

    var mPaint = TextPaint()
    var mText = ""
    // 行高
    var mLineHeight: Float = 0f
    // 文字拆分行数
    var mlinesNumber: Int = 0
    // 存储每行文字集合
    var textList = arrayListOf<String>()

    @JvmOverloads
    constructor(context: Context, attributeSet: AttributeSet? = null, defAttrStyle: Int = 0)
            : super(context, attributeSet, defAttrStyle) {

        // 初始化画笔
        initPaint()
        // 初始化各种自定义参数
        initAttrs(context, attributeSet, defAttrStyle)
        // 计算行高
        mLineHeight = calculateLineHeight()
    }

    /**
     * 初始化画笔
     */
    fun initPaint() {
        mPaint.color = Color.BLACK
        mPaint.strokeWidth = 1f
        mPaint.style = Paint.Style.FILL
        mPaint.isAntiAlias = true
    }

    /**
     * 初始化各种自定义参数
     */
    private fun initAttrs(context: Context, attributeSet: AttributeSet?, defAttrStyle: Int) {
        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CustomeTextView)
        (0..typedArray.indexCount)
                .asSequence()
                .map { typedArray.getIndex(it) }
                .forEach {
                    when (it) {
                    // 获取文字内容
                        R.styleable.CustomeTextView_android_text -> {
                            mText = typedArray.getString(R.styleable.CustomeTextView_android_text)
                        }
                    // 获取文字大小
                        R.styleable.CustomeTextView_android_textSize -> {
                            var textSize = typedArray.getDimensionPixelSize(R.styleable.CustomeTextView_android_textSize, 0).toFloat()
                            mPaint.textSize = textSize
                        }
                    }
                }
        typedArray.recycle()
    }

    /**
     * 计算 view 大小
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        var widthSize = MeasureSpec.getSize(widthMeasureSpec)

        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        var heightSize = MeasureSpec.getSize(heightMeasureSpec)

        // 当 view 的宽高是 warpContent 时，根据文字计算 view 所需大小
        if (widthMode == MeasureSpec.AT_MOST) {
            widthSize = calculateWidth(widthSize)
        }

        if (heightMode == MeasureSpec.AT_MOST) {
            heightSize = calculateHeight(widthSize)
        }

        // 计算文字分成几行
        calculateLines(widthSize)
        // 设置 view 的大小
        setMeasuredDimension(widthSize, heightSize)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 把传入的文字根据 view 的宽度，分割成一行一行的，便于绘制,我们一次只能绘制一行，多行文字就是一行行绘制出来的
        splitText()

        // 第一行文字的 baseline 的起始坐标
        var startX = 0f
        var startY = 0f - mPaint.fontMetrics.ascent

        // 遍历储存每行文字的集合，绘制每一行文字
        for ((index, text) in textList.withIndex()) {
            canvas?.drawText(text, startX, startY + index * mLineHeight, mPaint)
        }
    }

    /**
     * 计算行高
     */
    fun calculateLineHeight(): Float {
        return -mPaint.fontMetrics.ascent + mPaint.fontMetrics.bottom
    }

    /**
     * 计算文字会分割成几行绘制，由余数的话行数 +1
     */
    fun calculateLines(width: Int) {
        val measureWidth = mPaint.measureText(mText).toInt()
        mlinesNumber = if (measureWidth % width != 0) measureWidth / width + 1 else measureWidth / width
    }

    /**
     * 计算 view 所需宽度，view 的宽是 warpContent 时需要处理
     */
    fun calculateWidth(width: Int): Int {
        val measureWidth = mPaint.measureText(mText)
        return if (measureWidth >= width) width else measuredWidth
    }

    /**
     * 计算 view 总共的高度，view 的高是 warpContent 时需要处理
     */
    fun calculateHeight(width: Int): Int {

        val measureWidth = mPaint.measureText(mText).toInt()
        if (measureWidth <= width) {
            return mLineHeight.toInt()
        }
        return (mlinesNumber * mLineHeight).toInt()
    }

    /**
     * 分割文字成一行一行的
     */
    fun splitText() {

        var centerTextNum = mText.length / mlinesNumber
        var text: String = mText
        while (true) {
            // 先获取每行文字的数量
            val sigleLineTextNumber = getSigleLineTextNumber(text, width, centerTextNum)
            // 然后根据这个数量裁剪文字，把这行文字取出来，
            val lineText = text.substring(0, sigleLineTextNumber)
            // 把取出的每行文字存入集合
            textList.add(lineText)
            // 然后把取出的这行文字从源文字中删除，以便接下来的计算
            text = text.substring(sigleLineTextNumber, text.length)
            if (text.isEmpty()) break
        }
    }

    /**
     * 根据传入的文字，获取一行最多能显示的字符数
     */
    fun getSigleLineTextNumber(text: String, width: Int, centerTextNum: Int): Int {

        // 判断是不是最后一行，最后一行返回字符串长度
        if (text.length <= centerTextNum || mPaint.measureText(text) < width) {
            return text.length
        }

        var index = centerTextNum
        while (true) {
            // 从每行文字的中间数开始，一个字符的一个字符的增加文字测量数，一直到超过或等于指定宽度时，就是 view 每行能显示文字的字数
            val measureWidth = mPaint.measureText(text.substring(0, index) + 0.5f).toInt()
            if (measureWidth > width) {
                return index - 1
                break
            }
            if (measureWidth == width) {
                return index
                break
            }

            index++
        }
    }


}