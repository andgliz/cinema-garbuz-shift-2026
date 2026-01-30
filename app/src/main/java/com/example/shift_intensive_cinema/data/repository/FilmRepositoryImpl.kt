package com.example.shift_intensive_cinema.data.repository

import com.example.shift_intensive_cinema.data.mapper.toFilm
import com.example.shift_intensive_cinema.data.mapper.toSchedule
import com.example.shift_intensive_cinema.data.network.FilmApiService
import com.example.shift_intensive_cinema.domain.model.Film
import com.example.shift_intensive_cinema.domain.model.Schedule
import com.example.shift_intensive_cinema.domain.repository.FilmRepository

class FilmRepositoryImpl(
    private val filmApiService: FilmApiService
) : FilmRepository {

    override suspend fun getById(id: String): Film {
        return filmApiService.getFilm(id).film.toFilm()
    }

    override suspend fun getSchedule(id: String): List<Schedule> {
       return filmApiService.getSchedules(id).schedules.map { it.toSchedule() }
    }
}
