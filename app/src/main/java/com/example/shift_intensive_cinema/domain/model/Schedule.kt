package com.example.shift_intensive_cinema.domain.model

import java.time.LocalDate

data class Schedule(
    val date: LocalDate,
    val seances: List<Seance>,
)

data class Seance(
    val hall: List<Hall>,
    val time: String,
)

data class Hall(
    val name: String,
    val places: List<List<Place>>
)

data class Place(
    val type: String,
    val price: Int,
)
