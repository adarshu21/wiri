package com.example.wiri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wiri.R
import android.widget.TextView
import android.content.Intent
import com.example.wiri.Login
import com.example.wiri.Signup

class login_signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_signup)
        val t = findViewById<TextView>(R.id.loginer)
        val t1 = findViewById<TextView>(R.id.signuper)
        supportActionBar!!.hide()
        t.setOnClickListener {
            val switchActivityIntent = Intent(this@login_signup, Login::class.java)
            startActivity(switchActivityIntent)
        }
        t1.setOnClickListener {
            val switchActivityIntent = Intent(this@login_signup, Signup::class.java)
            startActivity(switchActivityIntent)
        }
    }
}