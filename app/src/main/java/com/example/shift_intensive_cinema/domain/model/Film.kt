package com.example.shift_intensive_cinema.domain.model

data class Film(
    val id: String,
    val name: String,
    val description: String,
    val releaseDate: String,
    val ageRating: String,
    val genres: List<String>,
    val userRatings: String,
    val image: String,
    val countryName: String,
)
