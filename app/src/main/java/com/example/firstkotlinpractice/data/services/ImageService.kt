package com.example.firstkotlinpractice.data.services

import com.example.firstkotlinpractice.data.models.Image
import retrofit2.Response
import retrofit2.http.GET

interface ImageService {

    @GET("/v2/list")
    suspend fun getImageList(): Response<List<Image>>
}