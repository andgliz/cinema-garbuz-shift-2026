package com.example.shift_intensive_cinema.domain.repository

import com.example.shift_intensive_cinema.domain.model.Film
import com.example.shift_intensive_cinema.domain.model.Schedule

interface FilmRepository {
    suspend fun getById(id: String): Film
    suspend fun getSchedule(id: String): List<Schedule>
}
