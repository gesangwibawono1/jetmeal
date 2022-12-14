package com.dicoding.jetmeal.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.jetmeal.R
import com.dicoding.jetmeal.model.Area
import com.dicoding.jetmeal.model.Category
import com.dicoding.jetmeal.ui.theme.JetMealTheme

@Composable
fun MealInfo(
    price: Int,
    area: String,
    category: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(
                    text = "Price : ",
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                )
                Text(
                    text = stringResource(R.string.price, price),
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                )
            }
            Divider(color = Color.LightGray, modifier = Modifier.fillMaxWidth().width(1.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Area",
                        style = MaterialTheme.typography.subtitle2.copy(
                            fontWeight = FontWeight.Bold
                        ),
                    )
                    Text(text = area)
                }
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Category",
                        style = MaterialTheme.typography.subtitle2.copy(
                            fontWeight = FontWeight.Bold
                        ),
                    )
                    Text(text = category)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MealInfoPreview() {
    val price = 5
    val area = Area.BRITISH.areaName
    val category = Category.BEEF.categoryName
    JetMealTheme {
        MealInfo(
            price = price,
            area = area,
            category = category,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )
    }
}