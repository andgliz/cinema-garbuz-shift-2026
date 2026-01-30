package com.example.shift_intensive_cinema.data.mapper

import com.example.shift_intensive_cinema.data.model.AgeRating
import com.example.shift_intensive_cinema.data.model.FilmDto
import com.example.shift_intensive_cinema.domain.model.Film

fun FilmDto.toFilm(): Film = Film(
    id = id,
    name = name,
    description = description,
    releaseDate = releaseDate.takeLast(4),
    ageRating = when (ageRating) {
        AgeRating.G -> "0+"
        AgeRating.PG -> "6+"
        AgeRating.PG13 -> "12+"
        AgeRating.R -> "16+"
        AgeRating.NC17 -> "18+"
    },
    genres = genres,
    userRatings = "Kinopoisk - " + userRatings.kinopoisk,
    image = "https://shift-intensive.ru/api" + image,
    countryName = country.name,
)
