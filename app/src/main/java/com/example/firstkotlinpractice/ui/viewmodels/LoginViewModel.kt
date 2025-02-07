package com.example.firstkotlinpractice.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstkotlinpractice.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun getUser(): String? {
        var user: String? = null
        viewModelScope.launch {
            user = userRepository.getUser()
        }
        return user
    }

    fun setUser(user: String) {
        viewModelScope.launch {
            userRepository.updateUser(user)
        }
    }

}