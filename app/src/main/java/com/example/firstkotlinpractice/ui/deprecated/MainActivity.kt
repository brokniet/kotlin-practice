package com.example.firstkotlinpractice.ui.deprecated

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstkotlinpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var username: String? = null

        binding.btnIngresar.setOnClickListener {
            if(!binding.inputUser.text.isNullOrEmpty() && !binding.inputPassword.text.isNullOrEmpty()) {
                username = binding.inputUser.text.toString()
                binding.inputUser.setText("")
                binding.inputPassword.setText("")
            }
        }
        binding.btnLeftTabbar.setOnClickListener { redirectToNewActivity(username) }
        binding.btnMiddleTabbar.setOnClickListener { redirectToNewActivity(username) }
        binding.btnRightTabbar.setOnClickListener { redirectToNewActivity(username) }
    }

    fun redirectToNewActivity(username: String?) {
        var intent = Intent(this, SecondActivity::class.java)
        if(!username.isNullOrEmpty()) intent.putExtra("USERNAME", username)
        startActivity(intent)
    }
}