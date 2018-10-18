package com.bloodcrown.bw.customeview

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.bloodcrown.bw.R
import kotlinx.android.synthetic.main.activity_flex_layout.*
import java.util.*

class FlexLayoutActivity : AppCompatActivity() {

    private var random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flex_layout)

        btn_add.setOnClickListener({
            view_flex.addView(createView())
        })
    }

    fun createView(): View {
        val textview: TextView = layoutInflater.inflate(R.layout.item_flex, null) as TextView
        textview.text = random.nextInt(10000).toString()

        val animatorSet = AnimatorSet()
        val animator1 = ObjectAnimator.ofFloat(textview, "translationY", -50f, 0f)
        val animator2 = ObjectAnimator.ofFloat(textview, "alpha", 0.3f, 1f)
        animatorSet.setDuration(500)
        animatorSet.playTogether(animator1, animator2)
        animatorSet.start()
        return textview
    }

}
