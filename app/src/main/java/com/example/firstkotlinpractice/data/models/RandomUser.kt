package com.example.firstkotlinpractice.data.models

data class RandomUser(
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val login: Login,
    val dob: Dob,
    val registered: Registered,
    val phone: String,
    val cell: String,
    val id: UserId,
    val picture: Picture,
    val nat: String
)
