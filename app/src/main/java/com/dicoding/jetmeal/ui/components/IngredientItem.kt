package com.dicoding.jetmeal.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.jetmeal.ui.theme.JetMealTheme

@Composable
fun IngredientItem(
    name: String,
    quantity: Double,
    unit: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp)
        ) {
            Text(
                text = name,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                modifier = Modifier.padding(bottom = 8.dp),
            )
            Divider(color = Color.LightGray, modifier = Modifier.fillMaxWidth().width(1.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = quantity.toString(),
                    style = MaterialTheme.typography.subtitle2,
                )
                Text(
                    text = unit,
                    style = MaterialTheme.typography.subtitle2.copy(
                        fontStyle = FontStyle.Italic
                    ),
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun IngredientItemPreview() {
    JetMealTheme {
        IngredientItem(
            name = "Beef",
            quantity = 1.0,
            unit = "kg",
            modifier = Modifier.width(140.dp),
        )
    }
}