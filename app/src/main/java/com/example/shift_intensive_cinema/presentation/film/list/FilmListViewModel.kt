package com.example.shift_intensive_cinema.presentation.film.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shift_intensive_cinema.domain.repository.FilmListRepository
import com.example.shift_intensive_cinema.presentation.film.model.toFilmViewData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import retrofit2.HttpException
import java.io.IOException

@KoinViewModel
class FilmListViewModel(
    private val filmListRepository: FilmListRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<FilmListUiState> =
        MutableStateFlow(FilmListUiState.Loading)
    val uiState: StateFlow<FilmListUiState> = _uiState.asStateFlow()

    init {
        setInitialViewState()
    }

    fun setInitialViewState() {
        viewModelScope.launch {
            _uiState.value = FilmListUiState.Loading
            _uiState.value = try {
                val filmList = filmListRepository.get().map { it.toFilmViewData() }
                FilmListUiState.Success(
                    filmList = filmList
                )
            } catch (e: IOException) {
                FilmListUiState.Error
            } catch (e: HttpException) {
                FilmListUiState.Error
            }
        }
    }
}
