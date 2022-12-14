package com.dicoding.jetmeal.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import com.dicoding.jetmeal.ui.theme.JetMealTheme

@Composable
fun TagsText(
    tags: List<String>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
    ) {
        for (tag in tags) {
            Text(
                text = "#$tag",
                style = MaterialTheme.typography.subtitle2.copy(
                    fontStyle = FontStyle.Italic
                ),
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TagsTextPreview() {
    val tags = listOf("Meat", "Pie")
    JetMealTheme {
        TagsText(
            tags = tags,
        )
    }
}
