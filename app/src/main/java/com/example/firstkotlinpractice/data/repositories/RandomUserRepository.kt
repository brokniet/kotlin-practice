package com.example.firstkotlinpractice.data.repositories

import com.example.firstkotlinpractice.data.models.ResponseRandomUser
import com.example.firstkotlinpractice.data.retrofit.RetrofitHelper
import com.example.firstkotlinpractice.data.services.RandomUserService

class RandomUserRepository {

    private val baseUrl = "https://randomuser.me"
    private val randomUserApi = RetrofitHelper
        .getInstance(baseUrl)
        .create(RandomUserService::class.java)

    suspend fun getRandomUser(): ResponseRandomUser {
        return randomUserApi.getRandomUserData()
    }
}