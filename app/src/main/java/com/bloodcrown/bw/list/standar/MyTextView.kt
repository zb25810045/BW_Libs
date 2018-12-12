package com.bloodcrown.bw.list.standar

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/12/7 下午2:21
 * 描述 ：
 */
class MyTextView : TextView {

    lateinit var show: (info: String, visibility: Int) -> Unit

    @JvmOverloads
    constructor(context: Context, attributeSet: AttributeSet? = null, defAttrStyle: Int = 0)
            : super(context, attributeSet, defAttrStyle) {
    }

    override fun onVisibilityChanged(changedView: View?, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        show(text.toString(),visibility)
    }


}