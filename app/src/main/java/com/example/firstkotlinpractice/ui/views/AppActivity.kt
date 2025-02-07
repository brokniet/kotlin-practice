package com.example.firstkotlinpractice.ui.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.firstkotlinpractice.R
import com.example.firstkotlinpractice.data.repositories.UserRepository
import com.example.firstkotlinpractice.databinding.ActivityAppBinding
import com.example.firstkotlinpractice.ui.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppBinding
    private val loginViewModel: LoginViewModel by viewModels()//PARA TEST, BORRAR DSP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvUser = binding.tvUser


        loginViewModel.user.observe(this, Observer { user ->
            tvUser.text = user
        })
        loginViewModel.getUser()
    }
}