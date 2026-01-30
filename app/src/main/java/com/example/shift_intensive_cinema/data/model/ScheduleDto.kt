package com.example.shift_intensive_cinema.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SchedulesResponse(
    val schedules: List<ScheduleDto>,
)

@Serializable
data class ScheduleDto(
    val date: String,
    val seances: List<SeanceDto>,
)

@Serializable
data class SeanceDto(
    val hall: List<HallDto>,
    val time: String,
)

@Serializable
data class HallDto(
    val name: String,
    val places: List<List<PlaceDto>>
)

@Serializable
data class PlaceDto(
    val type: String,
    val price: Int,
)
