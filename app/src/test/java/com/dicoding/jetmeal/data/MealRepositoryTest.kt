package com.dicoding.jetmeal.data

import org.junit.Assert.*

import org.junit.Test

class MealRepositoryTest {
    private val mealRepository = MealRepository.getInstance()

    @Test
    fun searchMealWithEmptyKeyword() {
        val result = mealRepository.searchMeal("")
        assertEquals(15, result.size)
    }

    @Test
    fun searchMealWithMatchKeyword() {
        val result = mealRepository.searchMeal("beef")
        assertEquals(4, result.size)
        assert(result[0].name.contains("beef", ignoreCase = true))
        assert(result[1].name.contains("beef", ignoreCase = true))
        assert(result[2].name.contains("beef", ignoreCase = true))
        assert(result[3].name.contains("beef", ignoreCase = true))
    }

    @Test
    fun searchMealWithUnmatchKeyword() {
        val result = mealRepository.searchMeal("sausage")
        assertEquals(0, result.size)
    }

    @Test
    fun getMealByCorrectId() {
        val result = mealRepository.getMealById("52874")
        assertNotNull(result)
        assertEquals("Beef and Mustard Pie", result.name)
    }

    @Test
    fun addOrRemoveFavoriteById() {
        mealRepository.addOrRemoveFavoriteById("52874")
        assertEquals(true, mealRepository.getMealById("52874").isFavorite)
        mealRepository.addOrRemoveFavoriteById("52874")
        assertEquals(false, mealRepository.getMealById("52874").isFavorite)
    }
}