package com.dicoding.jetmeal.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.jetmeal.ui.theme.JetMealTheme

@Composable
fun FavoriteToggle(
    isFavorite: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    if(isFavorite) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red, contentColor = Color.White),
            modifier = modifier
                .fillMaxWidth()
                .height(52.dp)
                .semantics(mergeDescendants = true) {
                    contentDescription = "Favorite Toggle"
                }
        ) {
            Text(
                text = "Remove from Favorites",
            )
        }
    } else {
        Button(
            onClick = onClick,
            modifier = modifier
                .fillMaxWidth()
                .height(52.dp)
                .semantics(mergeDescendants = true) {
                    contentDescription = "Favorite Toggle"
                }
        ) {
            Text(
                text = "Add to Favorites",
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FavoriteTogglePreview() {
    JetMealTheme {
        FavoriteToggle(
            isFavorite = true,
            onClick = {}
        )
    }
}