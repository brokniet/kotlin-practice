package com.example.firstkotlinpractice

import android.os.Bundle
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

        var inputUser = findViewById<TextInputEditText>(R.id.inputUser)
        var inputPassword = findViewById<TextInputEditText>(R.id.inputPassword)
        var btnIngresar = findViewById<Button>(R.id.btnIngresar)

        btnIngresar.setOnClickListener {
            inputUser.setText("")
            inputPassword.setText("")
        }
    }
}