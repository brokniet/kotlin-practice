package com.example.firstkotlinpractice.ui.viewmodels

import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstkotlinpractice.data.repositories.UserRepository
import com.example.firstkotlinpractice.ui.views.activities.AppActivity
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
            //_user.value = userRepository.getUser()
            _user.postValue(userRepository.getUser())
        }
    }

    fun setUser(user: String) {
        viewModelScope.launch {
            userRepository.updateUser(user)
            _user.postValue(user)
        }
    }

    fun isUserSaved(): Boolean {
        getUser()
        return !user.toString().isNullOrEmpty()
    }

    fun setUserAndNavigate(user: String, context: Context) {
        viewModelScope.launch {
           if(!user.isNullOrBlank()) {
                setUser(user)
                val intent = Intent(context, AppActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    fun clearUser() {
        _user.postValue("")
    }

}