package com.example.firstkotlinpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var textWelcome = findViewById<TextView>(R.id.textWelcome)
        var btnBack = findViewById<Button>(R.id.btnBack)
        var username = intent.extras?.getString("USERNAME").orEmpty()

        textWelcome.setText("Hola $username")

        btnBack.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
        }
    }
}