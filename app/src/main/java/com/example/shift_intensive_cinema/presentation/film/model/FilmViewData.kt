package com.example.shift_intensive_cinema.presentation.film.model

import com.example.shift_intensive_cinema.domain.model.Film

data class FilmViewData(
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

fun Film.toFilmViewData(): FilmViewData = FilmViewData(
    id = id,
    name = name,
    description = description,
    releaseDate = releaseDate,
    ageRating = ageRating,
    genres = genres,
    userRatings = userRatings,
    image = image,
    countryName = countryName
)
