package com.bloodcrown.bw.customeview

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.bloodcrown.basecomponents.utils.UnitUtils

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/10/16 上午9:15
 * 描述 ：
 */
class CustomeFlexLayout : ViewGroup {

    var ChildViewList = mutableMapOf<View, Rect>()
    var widthoffset: Int = 0
    var heightoffset: Int = 0

    @JvmOverloads
    constructor(context: Context, attributeSet: AttributeSet? = null, defAttrStyle: Int = 0)
            : super(context, attributeSet, defAttrStyle) {
        widthoffset = UnitUtils.dp2px(context, 10)
        heightoffset = UnitUtils.dp2px(context, 10)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        var widthSize = MeasureSpec.getSize(widthMeasureSpec)

        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        var heightSize = MeasureSpec.getSize(heightMeasureSpec)

        measureChildren(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(widthSize, calculateAllChildViewLayoutRect(widthSize))
    }

    fun calculateAllChildViewLayoutRect(maxWidth: Int): Int {

        var lineWidth: Int = -widthoffset
        var lineHeight: Int = -heightoffset
        var totalHeight: Int = 0
        for (index in 0..childCount - 1) {
            var rect = Rect()
            val childView = getChildAt(index)
            val width = childView.measuredWidth
            val height = childView.measuredHeight

            lineWidth += widthoffset + width
            if (height > lineHeight) lineHeight = height

            // 一行放不下了，需要新启动一行
            if (lineWidth > maxWidth) {

                // 行高加入view 总高度
                totalHeight += lineHeight + heightoffset

                // 计算本 view 的布局坐标
                rect.left = 0
                rect.right = width
                rect.top = totalHeight
                rect.bottom = totalHeight + height
                ChildViewList.put(childView, rect)

                if( index < childCount - 1 ){
                    // 行宽行高重置
                    lineWidth = width
                    lineHeight = 0
                }
            } else {
                // 计算本 view 的布局坐标
                rect.left = lineWidth - width
                rect.right = lineWidth
                rect.top = totalHeight
                rect.bottom = totalHeight + height
                ChildViewList.put(childView, rect)
            }

            // 最后一个view 把最后一行高度加入总高度
            if (index == childCount - 1) totalHeight += lineHeight + heightoffset
        }
        return totalHeight
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for ((view, rect) in ChildViewList) {
            view.layout(rect.left, rect.top, rect.right, rect.bottom)
        }
    }

}