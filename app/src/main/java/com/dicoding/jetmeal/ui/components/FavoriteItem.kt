package com.dicoding.jetmeal.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dicoding.jetmeal.ui.theme.JetMealTheme

@Composable
fun FavoriteItem(
    thumb: String,
    name: String,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = thumb,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FavoriteItemPreview() {
    JetMealTheme {
        FavoriteItem(
            thumb = "https://www.themealdb.com/images/media/meals/sytuqu1511553755.jpg",
            name = "Beef and Mustard Pie",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        )
    }
}