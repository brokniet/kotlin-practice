package com.example.firstkotlinpractice.data.models

data class ResponseRandomUser(
    val results: List<RandomUser>,
    val info: Info
)
