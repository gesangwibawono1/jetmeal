package com.dicoding.jetmeal.ui.navigation

sealed class Screen(val route: String) {
    object Search : Screen("search")
    object Favorites : Screen("favorites")
    object About : Screen("about")
    object DetailMeal : Screen("search/{mealId}") {
        fun createRoute(mealId: String) = "search/$mealId"
    }
}