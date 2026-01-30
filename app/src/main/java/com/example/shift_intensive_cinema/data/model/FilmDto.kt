package com.example.shift_intensive_cinema.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmListResponse(
    val films: List<FilmDto>,
)

@Serializable
data class FilmDto(
    val id: String,
    val name: String,
    val description: String,
    val releaseDate: String,
    val ageRating: AgeRating,
    val genres: List<String>,
    val userRatings: Rating,
    @SerialName(value = "img")
    val image: String,
    val country: Country,
)

enum class AgeRating {
    G,
    PG,
    PG13,
    R,
    NC17,
}

@Serializable
data class Rating(
    val kinopoisk: String,
    val imdb: String,
)

@Serializable
data class Country(
    val name: String,
    val code: String,
    val code2: String,
    val id: Int,
)
