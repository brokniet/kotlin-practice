package com.example.firstkotlinpractice.data.repositories

import com.example.firstkotlinpractice.data.models.Image
import com.example.firstkotlinpractice.data.retrofit.RetrofitHelper
import com.example.firstkotlinpractice.data.services.ImageService
import retrofit2.Response

class ImageRepository() {

    private val baseUrl = "https://picsum.photos/"
    private val imagesApi = RetrofitHelper.getInstance(baseUrl).create(ImageService::class.java)

    suspend fun getImages(): Response<List<Image>> {
        return imagesApi.getImageList()
    }
}