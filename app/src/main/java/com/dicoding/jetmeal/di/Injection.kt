package com.dicoding.jetmeal.di

import com.dicoding.jetmeal.data.MealRepository

object Injection {
    fun provideRepository(): MealRepository {
        return MealRepository.getInstance()
    }
}