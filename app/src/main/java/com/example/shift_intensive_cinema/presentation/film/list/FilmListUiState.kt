package com.example.shift_intensive_cinema.presentation.film.list

import com.example.shift_intensive_cinema.presentation.film.model.FilmViewData

sealed interface FilmListUiState {
    data class Success(
        val filmList: List<FilmViewData>,
    ) : FilmListUiState

    data object Loading : FilmListUiState
    data object Error : FilmListUiState
}
