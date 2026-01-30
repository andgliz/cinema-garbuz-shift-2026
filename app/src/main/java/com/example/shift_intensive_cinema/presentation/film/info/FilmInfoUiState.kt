package com.example.shift_intensive_cinema.presentation.film.info

import com.example.shift_intensive_cinema.presentation.film.model.FilmViewData

sealed interface FilmInfoUiState {
    data class Success(
        val film: FilmViewData,
    ) : FilmInfoUiState

    data object Loading : FilmInfoUiState
    data object Error : FilmInfoUiState
}
