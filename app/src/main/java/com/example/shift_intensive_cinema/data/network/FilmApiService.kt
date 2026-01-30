package com.example.shift_intensive_cinema.data.network

import com.example.shift_intensive_cinema.data.model.FilmListResponse
import com.example.shift_intensive_cinema.data.model.FilmResponse
import com.example.shift_intensive_cinema.data.model.SchedulesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmApiService {
    @GET("/api/cinema/films")
    suspend fun getFilmList(): FilmListResponse

    @GET("/api/cinema/film/{filmId}")
    suspend fun getFilm(@Path("filmId") filmId: String): FilmResponse

    @GET("/api/cinema/film/{filmId}/schedule")
    suspend fun getSchedules(@Path("filmId") filmId: String): SchedulesResponse
}
