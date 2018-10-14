package com.bloodcrown.bw.customeview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bloodcrown.bw.R
import kotlinx.android.synthetic.main.activity_custome_view.*

class CustomeViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custome_view)

        btn_textview.setOnClickListener( {

            var intent: Intent = Intent(this@CustomeViewActivity, CustomeTextviewActivity::class.java)
            this@CustomeViewActivity.startActivity(intent)
        } )


    }
}
