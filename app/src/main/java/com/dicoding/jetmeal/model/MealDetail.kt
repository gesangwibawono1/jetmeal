package com.dicoding.jetmeal.model

data class MealDetail(
    val id: String,
    val name: String,
    val thumb: String,
    var isFavorite: Boolean = false,
    val price: Int,
    val tags: List<String>,
    val area : Area,
    val category: Category,
    val ingredients: List<Ingredient>,
    val instruction: String,
)