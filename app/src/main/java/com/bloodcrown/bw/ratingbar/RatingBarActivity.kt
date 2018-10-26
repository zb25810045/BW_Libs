package com.bloodcrown.bw.ratingbar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.widget.Toast
import com.bloodcrown.bw.R
import kotlinx.android.synthetic.main.activity_rating_bar.*

class RatingBarActivity : AppCompatActivity() {

    companion object {
        init {
            // 保证 4.X 版本兼容矢量图
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_bar)

        view_ratingbar.click = { rating ->
            Toast.makeText(this@RatingBarActivity, "ratin = " + rating, Toast.LENGTH_SHORT).show();
        }

    }
}
