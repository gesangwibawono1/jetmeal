package com.dicoding.jetmeal.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.jetmeal.model.Ingredient
import com.dicoding.jetmeal.ui.theme.JetMealTheme

@Composable
fun IngredientRow(
    ingredients: List<Ingredient>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(ingredients) {
            IngredientItem(
                name = it.name,
                quantity = it.quantity,
                unit = it.unit,
                modifier = Modifier.width(140.dp),
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun IngredientRowPreview() {
    val ingredients = listOf(
        Ingredient(name = "Beef", quantity = 1.0, unit = "kg"),
        Ingredient(name = "Plain Flour", quantity = 2.0, unit = "tbs"),
        Ingredient(name = "Rapeseed Oil", quantity = 2.0, unit = "tbs"),
        Ingredient(name = "Red Wine", quantity = 200.0, unit = "ml"),
        Ingredient(name = "Beef Stock", quantity = 400.0, unit = "ml"),
        Ingredient(name = "Onion", quantity = 1.0, unit = "finely sliced"),
        Ingredient(name = "Carrots", quantity = 2.0, unit = "chopped"),
        Ingredient(name = "Thyme", quantity = 3.0, unit = "sprigs"),
        Ingredient(name = "Mustard", quantity = 2.0, unit = "tbs"),
        Ingredient(name = "Egg Yolks", quantity = 2.0, unit = "free-range"),
        Ingredient(name = "Pass Pastry", quantity = 400.0, unit = "g"),
        Ingredient(name = "Green Beans", quantity = 300.0, unit = "g"),
        Ingredient(name = "Butter", quantity = 25.0, unit = "g"),
        Ingredient(name = "Salt", quantity = 1.0, unit = "pinch"),
        Ingredient(name = "Pepper", quantity = 1.0, unit = "pinch"),
    )
    JetMealTheme {
        IngredientRow(
            ingredients = ingredients,
        )
    }
}