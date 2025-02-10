package com.example.firstkotlinpractice.data.services

import com.example.firstkotlinpractice.data.models.ResponseRandomUser
import retrofit2.http.GET

interface RandomUserService {

    @GET("/api")
    suspend fun getRandomUserData(): ResponseRandomUser
}