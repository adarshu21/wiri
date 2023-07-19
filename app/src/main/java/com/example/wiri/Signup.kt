package com.example.wiri

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import android.os.Bundle
import com.example.wiri.R
import android.widget.TextView
import android.widget.EditText
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.firestore.FirebaseFirestore
import com.google.android.gms.tasks.OnSuccessListener
import android.content.ContentValues
import android.content.Intent
import android.util.Log
import com.example.wiri.Login
import com.google.android.gms.tasks.OnFailureListener
import java.util.HashMap

class Signup : AppCompatActivity() {
    var mAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar!!.hide()
        val t = findViewById<TextView>(R.id.signup1)
        t.setOnClickListener {
            val email: String
            val password: String
            val emailTextView = findViewById<EditText>(R.id.user)
            val passwordTextView = findViewById<EditText>(R.id.pass)
            email = emailTextView.text.toString()
            password = passwordTextView.text.toString()
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(
                    applicationContext,
                    "Please enter email!!",
                    Toast.LENGTH_LONG
                )
                    .show()
            } else if (TextUtils.isEmpty(password)) {
                Toast.makeText(
                    applicationContext,
                    "Please enter password!!",
                    Toast.LENGTH_LONG
                )
                    .show()
            } else {
                mAuth
                    .createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                applicationContext,
                                "Registration successful!",
                                Toast.LENGTH_LONG
                            )
                                .show()
                            send()
                            // if the user created intent to login activity
                        } else {

                            // Registration failed
                            Toast.makeText(
                                applicationContext, "Registration failed!!"
                                        + " Please try again later",
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }
                    }
            }
        }
    }

    fun send() {
        val u: MutableMap<String, Any> = HashMap()
        val emailTextView = findViewById<EditText>(R.id.user)
        u["email"] = emailTextView.text.toString()
        val db = FirebaseFirestore.getInstance()
        db.collection("user")
            .add(u)
            .addOnSuccessListener { documentReference ->
                Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: " + documentReference.id)
                val switchActivityIntent = Intent(this@Signup, Login::class.java)
                startActivity(switchActivityIntent)
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error adding document", e)
                val switchActivityIntent = Intent(this@Signup, Login::class.java)
                startActivity(switchActivityIntent)
            }
    }
}