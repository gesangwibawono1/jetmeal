package com.dicoding.jetmeal.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dicoding.jetmeal.di.Injection
import com.dicoding.jetmeal.model.MealDetail
import com.dicoding.jetmeal.ui.ViewModelFactory
import com.dicoding.jetmeal.ui.common.UiState
import com.dicoding.jetmeal.ui.components.*

@Composable
fun DetailMealScreen(
    mealId: String,
    viewModel: DetailMealViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        )
    ),
    navigateBack: () -> Unit,
    navigateToCart: () -> Unit,
) {
    val myId = "52910"
    Column() {
        Text(text = "from param: $mealId")
        Text(text = "from myId: $myId")
        viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    viewModel.getMealDetailById(id = myId)
                }
                is UiState.Success -> {
                    val data = uiState.data
                    DetailMealContent(
                        mealDetail = data,
                        onBackClick = navigateBack,
                        onFavoriteToggle = {
                            viewModel.addOrRemoveFavoriteById(id = data.id)
                            navigateToCart()
                        }
                    )
                }
                is UiState.Error -> {}
            }
        }
    }
}

@Composable
fun DetailMealContent(
    mealDetail: MealDetail,
    onBackClick: () -> Unit,
    onFavoriteToggle: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState()),
    ) {
        ThumbMeal(
            thumb = mealDetail.thumb,
            name = mealDetail.name,
            tags = mealDetail.tags,
            onBackClick = onBackClick,
        )
        FavoriteToggle(
            isFavorite = mealDetail.isFavorite,
            onClick = onFavoriteToggle,
            modifier = Modifier
                .padding(16.dp).
                testTag("FavoriteToggle")
        )
        DetailSection(
            title = "Info",
            content = {
                MealInfo(
                    price = mealDetail.price,
                    area = mealDetail.area.areaName,
                    category = mealDetail.category.categoryName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                )
            }
        )
        DetailSection(
            title = "Ingredients",
            modifier = Modifier.padding(top = 12.dp),
            content = {
                IngredientRow(
                    ingredients = mealDetail.ingredients,
                )
            }
        )
        DetailSection(
            title = "Instruction",
            modifier = Modifier.padding(top = 12.dp),
            content = {
                InstructionCard(
                    instruction = mealDetail.instruction,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                )
            }
        )
    }
}