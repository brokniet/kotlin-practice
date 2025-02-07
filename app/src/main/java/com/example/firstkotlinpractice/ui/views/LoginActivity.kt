package com.example.firstkotlinpractice.ui.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.example.firstkotlinpractice.databinding.ActivityLoginBinding
import com.example.firstkotlinpractice.ui.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        setContentView(binding.root)

        val btnCambiarUsuario = binding.btnCambiarUsuario
        val btnIngresar = binding.btnIngresar
        val inputUser = binding.inputUser

        btnCambiarUsuario.isEnabled = false
        btnIngresar.setOnClickListener {
        }
    }
}