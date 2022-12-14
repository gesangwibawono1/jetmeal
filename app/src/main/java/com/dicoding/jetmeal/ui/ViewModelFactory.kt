package com.dicoding.jetmeal.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.jetmeal.data.MealRepository
import com.dicoding.jetmeal.ui.screen.detail.DetailMealViewModel
import com.dicoding.jetmeal.ui.screen.favorites.FavoritesViewModel
import com.dicoding.jetmeal.ui.screen.search.SearchViewModel

class ViewModelFactory(private val repository: MealRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailMealViewModel::class.java)) {
            return DetailMealViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(FavoritesViewModel::class.java)) {
            return FavoritesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}