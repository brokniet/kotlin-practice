package com.example.firstkotlinpractice.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstkotlinpractice.data.models.RandomUser
import com.example.firstkotlinpractice.data.models.ResponseRandomUser
import com.example.firstkotlinpractice.data.repositories.RandomUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val randomUserRepository: RandomUserRepository
): ViewModel() {

    private val _randomUser = MutableLiveData<ResponseRandomUser>()
    val randomUser: LiveData<ResponseRandomUser> = _randomUser

    init {
        loadRandomUser()
    }

    public fun loadRandomUser() {
        viewModelScope.launch {
            try {
                _randomUser.postValue(randomUserRepository.getRandomUser())
            } catch (e: Exception) {
                Log.e("Error", "Error cargando random user: $e")
                //agregar manejo
            }
        }
    }

    public fun getFullName(): String {
        val title = randomUser.value?.results?.get(0)?.name?.title
        val first = randomUser.value?.results?.get(0)?.name?.first
        val last = randomUser.value?.results?.get(0)?.name?.last
        return "$title $first $last"
    }

    public fun getGender(): String {
        val gender = randomUser.value?.results?.get(0)?.gender
        return "$gender"
    }

    public fun getAge(): String {
        val age = randomUser.value?.results?.get(0)?.dob?.age
        return "$age"
    }

    public fun getCountry(): String {
        val country = randomUser.value?.results?.get(0)?.location?.country
        return "$country"
    }
}