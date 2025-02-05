package com.example.firstkotlinpractice.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstkotlinpractice.R
import com.example.firstkotlinpractice.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnCambiarUsuario = binding.btnCambiarUsuario
        val btnIngresar = binding.btnIngresar
        val inputUser = binding.inputUser

        btnCambiarUsuario.isEnabled = false
    }
}