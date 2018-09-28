package com.bloodcrown.basecomponents.view.textview

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/9/27 下午5:16
 * 描述 ：
 */
class MarqueeTextView : TextView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun isFocused(): Boolean {
        return true
    }

}