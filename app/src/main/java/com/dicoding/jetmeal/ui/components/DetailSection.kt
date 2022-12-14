package com.dicoding.jetmeal.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.jetmeal.model.Area
import com.dicoding.jetmeal.model.Category
import com.dicoding.jetmeal.ui.theme.JetMealTheme

@Composable
fun DetailSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        SectionText(title, modifier)
        content()
    }
}

@Composable
@Preview(showBackground = true)
fun DetailSectionPreview() {
    val price = 5
    val area = Area.BRITISH.areaName
    val category = Category.BEEF.categoryName
    JetMealTheme {
        DetailSection(
            title = "Info",
            content = {
                MealInfo(
                    price = price,
                    area = area,
                    category = category,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                )
            }
        )
    }
}