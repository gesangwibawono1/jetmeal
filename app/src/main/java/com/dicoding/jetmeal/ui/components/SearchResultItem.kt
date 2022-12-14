package com.dicoding.jetmeal.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dicoding.jetmeal.R
import com.dicoding.jetmeal.ui.theme.JetMealTheme

@Composable
fun SearchResultItem(
    thumb: String,
    name: String,
    price: Int,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = modifier,
    ) {
        Card(
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.width(170.dp),
        ) {
            Column {
                AsyncImage(
                    model = thumb,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(170.dp),
                )
                Text(
                    text = name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    modifier = Modifier.padding(horizontal = 8.dp),
                )
                Text(
                    text = stringResource(R.string.price, price),
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .padding(bottom = 8.dp),
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SearchResultItemPreview() {
    JetMealTheme {
        SearchResultItem(
            thumb = "https://www.themealdb.com/images/media/meals/sytuqu1511553755.jpg",
            name = "Beef and Mustard Pie",
            price = 5,
        )
    }
}