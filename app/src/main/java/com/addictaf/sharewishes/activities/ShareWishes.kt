package com.addictaf.sharewishes.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.addictaf.sharewishes.R
import java.util.*


class ShareWishes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_wishes)

        Timer().schedule(object: TimerTask(){
            override fun run() {
                val intent = Intent(this@ShareWishes, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        },1200L)
    }
}
