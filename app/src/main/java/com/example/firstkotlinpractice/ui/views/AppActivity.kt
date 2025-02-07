package com.example.firstkotlinpractice.ui.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.firstkotlinpractice.R
import com.example.firstkotlinpractice.data.repositories.UserRepository
import com.example.firstkotlinpractice.databinding.ActivityAppBinding
import com.example.firstkotlinpractice.ui.viewmodels.LoginViewModel

class AppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppBinding
    private lateinit var loginViewModel: LoginViewModel//PARA TEST, BORRAR DSP


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]//PARA TEST, BORRAR DSP
        setContentView(binding.root)

        val tvUser = binding.tvUser
        if(loginViewModel.getUser() != null) tvUser.text = loginViewModel.getUser()//PARA TEST, BORRAR DSP


    }
}