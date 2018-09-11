package com.bloodcrown.bw.spannable

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import com.bloodcrown.basecomponents.toast.ToastComponent
import com.bloodcrown.baselibs.DisplayUtils
import com.bloodcrown.baselibs.SpanUtils
import com.bloodcrown.bw.R
import kotlinx.android.synthetic.main.activity_spannable.*

class SpannableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spannable)


        // 前景色
        SpanUtils
                .with(tx01)
                .foregroundColor(Color.BLUE, tx01.text.indexOf("-") + 1, tx01.text.length)
                .show()


        // 背景色
        SpanUtils
                .with(tx02)
                .backgroundColor(Color.RED, tx02.text.indexOf("-") + 1, tx02.text.length)
                .show()


        // 相对文字大小
        SpanUtils
                .with(tx03)
                .relativeTextSize(1.6f, tx03.text.indexOf("-") + 1, tx03.text.length)
                .show()


        // 绝对文字大小
        SpanUtils
                .with(tx031)
                .absoluteTextSize(DisplayUtils.sp2px(this@SpannableActivity, 26), tx031.text.indexOf("-") + 1, tx031.text.length)
                .show()


        // 中划线
        SpanUtils
                .with(tx04)
                .middleLine(tx04.text.indexOf("-") + 1, tx04.text.length)
                .show()


        // 下划线
        SpanUtils
                .with(tx05)
                .underLine(tx05.text.indexOf("-") + 1, tx05.text.length)
                .show()


        // 上标
        SpanUtils
                .with(tx06)
                .topFlag(tx06.text.indexOf("-") + 1, tx06.text.length)
                .relativeTextSize(0.5f, tx06.text.indexOf("-") + 1, tx06.text.length)
                .show()


        // 下标
        SpanUtils
                .with(tx07)
                .bottomFlag(tx07.text.indexOf("-") + 1, tx07.text.length)
                .relativeTextSize(0.5f, tx07.text.indexOf("-") + 1, tx07.text.length)
                .show()


        // 斜体、粗体
        SpanUtils
                .with(tx08)
                .bold(tx08.text.indexOf("-") + 1, tx07.text.length)
                .italic(tx08.text.indexOf("、") + 1, tx08.text.length)
                .show()


        // 图片
        val drawable = resources.getDrawable(R.mipmap.ic_launcher)
        drawable.setBounds(0, 0, 80, 80)

        var text = StringBuilder(tx09.text)
        text.insert(text.indexOf("-") + 1, "kkkk")
        tx09.setText(text)

        SpanUtils
                .with(tx09)
                .image(drawable, text.indexOf("k"), text.indexOf("k") + 4)
                .show()


        // 可点击区域
        SpanUtils
                .with(tx10)
                .clickable(tx10, MyClickSpan(), tx10.text.indexOf("-") + 1, tx10.text.length)
                .show()


        // 超链接
        SpanUtils
                .with(tx11)
                .url(tx11, "http://www.sina.com", tx11.text.indexOf("-") + 1, tx11.text.length)
                .show()

    }

    inner class MyClickSpan : ClickableSpan() {

        override fun updateDrawState(ds: TextPaint) {
            // 不显示下划线
//            ds.isUnderlineText = false
        }

        override fun onClick(widget: View?) {
            ToastComponent.instance.show("文字被点击了......")
        }
    }

}
