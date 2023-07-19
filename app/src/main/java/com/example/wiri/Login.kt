package com.example.wiri

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import android.os.Bundle
import com.example.wiri.R
import android.widget.TextView
import android.widget.EditText
import com.example.wiri.Login
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import android.widget.Toast
import android.content.Intent
import com.example.wiri.MainActivity

class Login : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        supportActionBar!!.hide()
        mAuth = FirebaseAuth.getInstance()
        val t = findViewById<TextView>(R.id.login1)
        t.setOnClickListener {
            val t = findViewById<EditText>(R.id.name)
            s = t.text.toString()
            val email: String
            val password: String
            val emailTextView = findViewById<EditText>(R.id.name)
            val passwordTextView = findViewById<EditText>(R.id.password)
            email = emailTextView.text.toString()
            password = passwordTextView.text.toString()
            mAuth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            applicationContext,
                            "Login successful!!",
                            Toast.LENGTH_LONG
                        )
                            .show()

                        // hide the progress bar

                        // if sign-in is successful
                        // intent to home activity
                        val intent = Intent(
                            this@Login,
                            MainActivity::class.java
                        )
                        startActivity(intent)
                    } else {

                        // sign-in failed
                        Toast.makeText(
                            applicationContext,
                            "Login failed!!",
                            Toast.LENGTH_LONG
                        )
                            .show()

                        // hide the progress bar
                    }
                }
        }
    }

    companion object {
        var s = ""
    }
}