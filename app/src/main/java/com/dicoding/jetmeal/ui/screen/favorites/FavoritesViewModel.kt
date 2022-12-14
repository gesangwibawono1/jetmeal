package com.dicoding.jetmeal.ui.screen.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.jetmeal.data.MealRepository
import com.dicoding.jetmeal.model.Favorite
import com.dicoding.jetmeal.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val repository: MealRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Favorite>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Favorite>>>
        get() = _uiState

    fun getAllFavorites() {
        viewModelScope.launch {
            repository.getAllFavorites()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }
}