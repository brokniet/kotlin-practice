package com.example.firstkotlinpractice.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _user = MutableLiveData<String>()
    val user: LiveData<String> = _user

    fun getUser() {
        viewModelScope.launch {
            _user.value = userRepository.getUser()
        }
    }

    fun setUser(user: String) {
        viewModelScope.launch {
            userRepository.updateUser(user)
        }
    }

}