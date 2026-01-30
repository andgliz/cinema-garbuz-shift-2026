package com.example.shift_intensive_cinema.data.network

import com.example.shift_intensive_cinema.data.model.FilmListResponse
import retrofit2.http.GET

interface FilmApiService {
    @GET("/api/cinema/films")
    suspend fun getFilmList(): FilmListResponse
}
