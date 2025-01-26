package com.example.firstkotlinpractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var username: String? = null
        var inputUser = findViewById<TextInputEditText>(R.id.inputUser)
        var inputPassword = findViewById<TextInputEditText>(R.id.inputPassword)
        var btnIngresar = findViewById<Button>(R.id.btnIngresar)
        var btnLeftTabbar = findViewById<Button>(R.id.btnLeftTabbar)
        var btnMiddleTabbar = findViewById<Button>(R.id.btnMiddleTabbar)
        var btnRightTabbar = findViewById<Button>(R.id.btnRightTabbar)

        btnIngresar.setOnClickListener {
            if(!inputUser.text.isNullOrEmpty() && !inputPassword.text.isNullOrEmpty()) {
                username = inputUser.text.toString()
                inputUser.setText("")
                inputPassword.setText("")
            }
        }
        btnLeftTabbar.setOnClickListener { redirectToNewActivity(username) }
        btnMiddleTabbar.setOnClickListener { redirectToNewActivity(username) }
        btnRightTabbar.setOnClickListener { redirectToNewActivity(username) }
    }

    fun redirectToNewActivity(username: String?) {
        var intent = Intent(this, SecondActivity::class.java)
        if(!username.isNullOrEmpty()) intent.putExtra("USERNAME", username)
        startActivity(intent)
    }
}