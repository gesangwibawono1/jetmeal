package com.dicoding.jetmeal.ui.screen.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dicoding.jetmeal.data.MealRepository
import com.dicoding.jetmeal.model.Meal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchViewModel(
    private val repository: MealRepository
) : ViewModel() {
    private val _meals = MutableStateFlow(
        repository.searchMeal("")
    )
    val meals: StateFlow<List<Meal>> get() = _meals

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(keyword: String) {
        _query.value = keyword
        _meals.value = repository.searchMeal(_query.value)
    }
}