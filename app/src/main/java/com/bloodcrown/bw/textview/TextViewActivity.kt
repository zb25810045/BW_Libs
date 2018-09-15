package com.bloodcrown.bw.textview

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bloodcrown.baselibs.animator.LayoutRotationAnimator
import com.bloodcrown.bw.R
import kotlinx.android.synthetic.main.activity_text_view.*


class TextViewActivity : AppCompatActivity() {

    lateinit var layoutAnimator: LayoutRotationAnimator


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)

        layoutAnimator = LayoutRotationAnimator(btn01)
        layoutAnimator.stateChangeListener = object : LayoutRotationAnimator.IStateChangeListener {
            override fun showA() {
                btn01.setText("正面")
                btn01.setBackgroundColor(Color.BLUE)
            }

            override fun showB() {
                btn01.setText("反面")
                btn01.setBackgroundColor(Color.RED)
            }
        }

        btn01.setOnClickListener({
            layoutAnimator.start()
        })
    }

}
