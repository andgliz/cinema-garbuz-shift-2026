package com.example.shift_intensive_cinema.data.mapper

import com.example.shift_intensive_cinema.data.model.HallDto
import com.example.shift_intensive_cinema.data.model.PlaceDto
import com.example.shift_intensive_cinema.data.model.ScheduleDto
import com.example.shift_intensive_cinema.data.model.SeanceDto
import com.example.shift_intensive_cinema.domain.model.Hall
import com.example.shift_intensive_cinema.domain.model.Place
import com.example.shift_intensive_cinema.domain.model.Schedule
import com.example.shift_intensive_cinema.domain.model.Seance
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun ScheduleDto.toSchedule(): Schedule = Schedule(
    date = date.toLocalDate(),
    seances = seances.map { it.toSeance() },
)

fun SeanceDto.toSeance(): Seance = Seance(
    hall = hall.map { it.toHall() },
    time = time,
)

fun HallDto.toHall(): Hall = Hall(
    name = name,
    places = places.map { row -> row.map { it.toPlace() } },
)

fun PlaceDto.toPlace(): Place = Place(
    type = type,
    price = price,
)

fun String.toLocalDate(): LocalDate {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yy")
    return LocalDate.parse(this, formatter)
}
