package com.dicoding.jetmeal.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.jetmeal.data.MealRepository
import com.dicoding.jetmeal.model.MealDetail
import com.dicoding.jetmeal.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailMealViewModel(
    private val repository: MealRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<MealDetail>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<MealDetail>>
        get() = _uiState

    fun getMealDetailById(id: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getMealById(id))
        }
    }

    fun addOrRemoveFavoriteById(id: String) {
        viewModelScope.launch {
            repository.addOrRemoveFavoriteById(id)
        }
    }
}