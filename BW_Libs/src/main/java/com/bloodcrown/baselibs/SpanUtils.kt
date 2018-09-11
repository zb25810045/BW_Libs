package com.bloodcrown.baselibs

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.*
import android.widget.TextView

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/9/10 下午9:06
 * 描述 ：
 */
class SpanUtils(text: String) {

    // SpannableString 文字样式对象
    lateinit var spannable: SpannableString
    // 关联的 view
    var textView: TextView? = null

    companion object {

        /**
         * 全局静态入口
         */
        fun with(text: String): SpanUtils {
            return SpanUtils(text)
        }

        fun with(textView: TextView): SpanUtils {
            return SpanUtils(textView, textView.text.toString())
        }
    }

    /**
     * 主构造函数里，初始化 SpannableString 对象
     */
    init {
        this.spannable = SpannableString(text)
    }

    constructor(textView: TextView, text: String) : this(text) {
        this.textView = textView
    }

    /**
     * 返回最终结果
     */
    fun getString(): String {
        return spannable.toString()
    }

    /**
     * 返回最终结果
     */
    fun getSpannableString(): SpannableString {
        return spannable
    }

    /**
     * 显示
     */
    fun show() {
        textView?.setText(spannable)
    }

    /**
     * 显示
     */
    fun show(textView: TextView?) {
        textView?.setText(spannable)
    }

    /**
     * 添加前景色
     */
    fun foregroundColor(color: Int, startIndex: Int, endIndex: Int): SpanUtils {
        var forColorSpan = ForegroundColorSpan(color)
        spannable.setSpan(forColorSpan, startIndex, endIndex, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
        return this@SpanUtils
    }

    /**
     * 添加前景色
     */
    fun backgroundColor(color: Int, startIndex: Int, endIndex: Int): SpanUtils {
        var backColorSpan = BackgroundColorSpan(color)
        spannable.setSpan(backColorSpan, startIndex, endIndex, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
        return this@SpanUtils
    }

    /**
     * 相对文字大小
     * size: 应使用诸如 1.2F 这样的参数格式
     */
    fun relativeTextSize(size: Float, startIndex: Int, endIndex: Int): SpanUtils {
        var relativeSizeSpan = RelativeSizeSpan(size)
        spannable.setSpan(relativeSizeSpan, startIndex, endIndex, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
        return this@SpanUtils
    }

    /**
     * 绝对文字大小
     * size: 应使用 sp 转换成的 int 值
     */
    fun absoluteTextSize(size: Int, startIndex: Int, endIndex: Int): SpanUtils {
        var absoluteSizeSpan = AbsoluteSizeSpan(size)
        spannable.setSpan(absoluteSizeSpan, startIndex, endIndex, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
        return this@SpanUtils
    }

    /**
     * 中划线
     */
    fun middleLine(startIndex: Int, endIndex: Int): SpanUtils {
        var strikethroughSpan = StrikethroughSpan()
        spannable.setSpan(strikethroughSpan, startIndex, endIndex, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
        return this@SpanUtils
    }

    /**
     * 下划线
     */
    fun underLine(startIndex: Int, endIndex: Int): SpanUtils {
        var underLineSpan = UnderlineSpan()
        spannable.setSpan(underLineSpan, startIndex, endIndex, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
        return this@SpanUtils
    }

    /**
     * 上标
     * 请允许我使用自创单词，因为原生单词实在不好记忆，也容易和下标混淆
     */
    fun topFlag(startIndex: Int, endIndex: Int): SpanUtils {
        var superscriptSpan = SuperscriptSpan()
        spannable.setSpan(superscriptSpan, startIndex, endIndex, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
        return this@SpanUtils
    }

    /**
     * 下标
     * 请允许我使用自创单词，因为原生单词实在不好记忆，也容易和上标混淆
     */
    fun bottomFlag(startIndex: Int, endIndex: Int): SpanUtils {
        var subscriptSpan = SubscriptSpan()
        spannable.setSpan(subscriptSpan, startIndex, endIndex, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
        return this@SpanUtils
    }

    /**
     * 粗体
     */
    fun bold(startIndex: Int, endIndex: Int): SpanUtils {
        var boldSpan = StyleSpan(Typeface.BOLD)
        spannable.setSpan(boldSpan, startIndex, endIndex, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
        return this@SpanUtils
    }

    /**
     * 斜体
     */
    fun italic(startIndex: Int, endIndex: Int): SpanUtils {
        var italicSpan = StyleSpan(Typeface.ITALIC)
        spannable.setSpan(italicSpan, startIndex, endIndex, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
        return this@SpanUtils
    }

    /**
     * 斜粗体
     */
    fun italicAndBlod(startIndex: Int, endIndex: Int): SpanUtils {
        var italicAndBlodSpan = StyleSpan(Typeface.BOLD_ITALIC)
        spannable.setSpan(italicAndBlodSpan, startIndex, endIndex, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
        return this@SpanUtils
    }

    /**
     * 斜粗体
     * drawable: 图片必须显示的指名大小，才能有效显示，请参考 - drawable.setBounds(0, 0, 80, 80)
     */
    fun image(drawable: Drawable, startIndex: Int, endIndex: Int): SpanUtils {
        var imageSpan = ImageSpan(drawable)
        spannable.setSpan(imageSpan, startIndex, endIndex, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
        return this@SpanUtils
    }

    /**
     * 可点击区域
     * textView： 必方法才能实现点击须设置 setMovementMethod()
     */
    fun clickable(textView: TextView, ClickableSpan: ClickableSpan, startIndex: Int, endIndex: Int): SpanUtils {
        spannable.setSpan(ClickableSpan, startIndex, endIndex, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
        textView.setMovementMethod(LinkMovementMethod.getInstance())
        return this@SpanUtils
    }

    /**
     * 超链接
     * adress: 必须加 http:// 协议才能正常跳转到系统浏览器
     */
    fun url(textView: TextView, adress: String, startIndex: Int, endIndex: Int): SpanUtils {
        var urlSpan = URLSpan(adress)
        spannable.setSpan(urlSpan, startIndex, endIndex, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
        textView.setMovementMethod(LinkMovementMethod.getInstance())
        return this@SpanUtils
    }

}