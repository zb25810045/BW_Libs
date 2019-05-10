package com.bloodcrown.basecomponents.applicaton.exit

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bloodcrown.basecomponents.R

class ExitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exit)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent == null) return

        val action: Int = intent.getIntExtra(ExitMessage.MESSAGE_ACTION, ExitMessage.ACTION_EXIT)
        when (action) {
            ExitMessage.ACTION_EXIT -> this@ExitActivity.finish()
            else -> this@ExitActivity.finish()
        }
    }

}
