package com.bloodcrown.bw.customeview

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bloodcrown.bw.customeview.pieview.PieViewActivity
import com.bloodcrown.bw.R
import com.bloodcrown.bw.customeview.flexbox.FlexLayoutActivity
import com.bloodcrown.bw.customeview.ratingbar.RatingBarActivity
import com.bloodcrown.bw.customeview.taiji.TaijiActivity
import com.bloodcrown.bw.customeview.textview.CustomeTextviewActivity
import kotlinx.android.synthetic.main.activity_custome_view.*

class CustomeViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custome_view)

        btn_textview.setOnClickListener({

            var intent: Intent = Intent(this@CustomeViewActivity, CustomeTextviewActivity::class.java)
            this@CustomeViewActivity.startActivity(intent)
        })

        btn_flexlayout.setOnClickListener({

            var intent: Intent = Intent(this@CustomeViewActivity, FlexLayoutActivity::class.java)
            this@CustomeViewActivity.startActivity(intent)
        })

        btn_ratingBar.setOnClickListener({

            var intent: Intent = Intent(this@CustomeViewActivity, RatingBarActivity::class.java)
            this@CustomeViewActivity.startActivity(intent)
        })

        btn_view4.setOnClickListener({

            var intent: Intent = Intent(this@CustomeViewActivity, PieViewActivity::class.java)
            this@CustomeViewActivity.startActivity(intent)
        })

        btn_taiji.setOnClickListener({

            var intent: Intent = Intent(this@CustomeViewActivity, TaijiActivity::class.java)
            this@CustomeViewActivity.startActivity(intent)
        })


    }
}
