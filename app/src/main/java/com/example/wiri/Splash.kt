package com.example.wiri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wiri.R
import android.content.Intent
import android.os.Handler
import com.example.wiri.login_signup
import java.util.concurrent.TimeUnit

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar!!.hide()
        try {
            TimeUnit.SECONDS.sleep(1)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        Check.i = 0
        Handler().postDelayed({
            val i = Intent(this@Splash, login_signup::class.java)
            startActivity(i)
            finish()
        }, 3000)
    }
}