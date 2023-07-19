package com.example.wiri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wiri.R

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        supportActionBar!!.hide()
    }
}