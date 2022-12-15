package com.dicoding.jetmeal.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.dicoding.jetmeal.helper.mapInPlace
import com.dicoding.jetmeal.model.Favorite
import com.dicoding.jetmeal.model.Meal
import com.dicoding.jetmeal.model.MealDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.time.LocalDateTime

class MealRepository {
    private val meals = mutableListOf<MealDetail>()

    init {
        if (meals.isEmpty()) {
            FakeMealDataSource.dummyMeals.forEach {
                meals.add( it )
            }
        }
    }

    fun searchMeal(keyword: String): List<Meal> {
        val searchedMeal = mutableListOf<Meal>()
        meals.forEach {
            if (it.name.contains(keyword, ignoreCase = true)) {
                searchedMeal.add(
                    Meal(
                        id = it.id,
                        name = it.name,
                        thumb = it.thumb,
                        price = it.price,
                    )
                )
            }
        }
        return searchedMeal
    }

    fun getMealById(id: String) : MealDetail {
        return meals.first{
            it.id == id
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAllFavorites() : Flow<List<Favorite>> {
        val favorites = mutableListOf<Favorite>()
        meals.sortBy { it.updatedAt }
        meals.forEach {
            if (it.isFavorite) {
                favorites.add(
                    Favorite(
                        id = it.id,
                        name = it.name,
                        thumb = it.thumb,
                    )
                )
            }
        }
        return flowOf(favorites)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addOrRemoveFavoriteById(id: String) {
        meals.mapInPlace {
                if (it.id == id) {
                    it.isFavorite = !it.isFavorite
                    it.updatedAt = LocalDateTime.now()
                    return@mapInPlace it
                } else it
        }
    }

    companion object {
        @Volatile
        private var instance: MealRepository? = null

        fun getInstance(): MealRepository =
            instance ?: synchronized(this) {
                MealRepository().apply {
                    instance = this
                }
            }
    }
}