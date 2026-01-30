package com.example.shift_intensive_cinema.domain.repository

import com.example.shift_intensive_cinema.domain.model.Film

interface FilmListRepository {
    suspend fun get(): List<Film>
}
