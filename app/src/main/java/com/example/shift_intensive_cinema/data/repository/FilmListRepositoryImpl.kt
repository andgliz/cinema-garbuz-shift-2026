package com.example.shift_intensive_cinema.data.repository

import com.example.shift_intensive_cinema.data.mapper.toFilm
import com.example.shift_intensive_cinema.data.network.FilmApiService
import com.example.shift_intensive_cinema.domain.model.Film
import com.example.shift_intensive_cinema.domain.repository.FilmListRepository

class FilmListRepositoryImpl(
    private val filmApiService: FilmApiService,
) : FilmListRepository {

    override suspend fun get(): List<Film> {
        return filmApiService.getFilmList().films.map { it.toFilm() }
    }

}
