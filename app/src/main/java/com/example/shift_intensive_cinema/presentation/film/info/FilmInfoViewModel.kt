package com.example.shift_intensive_cinema.presentation.film.info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shift_intensive_cinema.domain.repository.FilmRepository
import com.example.shift_intensive_cinema.presentation.film.model.toFilmViewData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import retrofit2.HttpException
import java.io.IOException

@KoinViewModel
class FilmInfoViewModel(
    private val filmRepository: FilmRepository,
    private val filmId: String,
): ViewModel() {

    private val _uiState: MutableStateFlow<FilmInfoUiState> =
        MutableStateFlow(FilmInfoUiState.Loading)
    val uiState: StateFlow<FilmInfoUiState> = _uiState.asStateFlow()

    init {
        setInitialViewState()
    }

    fun setInitialViewState(filmId: String = this.filmId){
        viewModelScope.launch {
            _uiState.value = FilmInfoUiState.Loading
            _uiState.value = try {
                val film = filmRepository.getById(filmId).toFilmViewData()
                FilmInfoUiState.Success(
                    film = film
                )
            } catch (e: IOException) {
                FilmInfoUiState.Error
            } catch (e: HttpException) {
                FilmInfoUiState.Error
            }
        }
    }
}
