package com.dicoding.jetmeal.ui.screen.favorites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.jetmeal.di.Injection
import com.dicoding.jetmeal.model.Favorite
import com.dicoding.jetmeal.R
import com.dicoding.jetmeal.ui.ViewModelFactory
import com.dicoding.jetmeal.ui.common.UiState
import com.dicoding.jetmeal.ui.components.FavoriteItem
import com.dicoding.jetmeal.ui.components.ShareButton
import com.dicoding.jetmeal.ui.theme.JetMealTheme

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    onShareButtonClicked: (String) -> Unit,
    navigateToDetail: (String) -> Unit,
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllFavorites()
            }
            is UiState.Success -> {
                FavoritesContent(
                    favorites = uiState.data,
                    onShareButtonClicked = onShareButtonClicked,
                    navigateToDetail = navigateToDetail,
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun FavoritesContent(
    favorites: List<Favorite>,
    onShareButtonClicked: (String) -> Unit,
    navigateToDetail: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val shareMessage = favorites.joinToString {
        it.name
    }
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TopAppBar(backgroundColor = MaterialTheme.colors.surface) {
            Text(
                text = stringResource(R.string.menu_favorites),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
        ShareButton(
            text = stringResource(R.string.share_message),
            enabled = favorites.isNotEmpty(),
            onClick = {
                      onShareButtonClicked(shareMessage)
            },
            modifier = Modifier.padding(16.dp)
        )
        if (favorites.isNotEmpty()) {
            LazyColumn {
                items(favorites) {
                    FavoriteItem(
                        thumb = it.thumb,
                        name = it.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                            navigateToDetail(it.id)
                        },
                    )
                }
            }
        } else {
            Text(
                text = stringResource(R.string.no_favorites),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FavoritesContentPreview() {
    val favorites = listOf(
        Favorite(
            id = "52874",
            name = "Beef and Mustard Pie",
            thumb = "https://www.themealdb.com/images/media/meals/sytuqu1511553755.jpg",
        ),
        Favorite(
            id = "53064",
            name = "Fettuccine Alfredo",
            thumb = "https://www.themealdb.com/images/media/meals/0jv5gx1661040802.jpg",
        ),
        Favorite(
            id = "52972",
            name = "Tunisian Lamb Soup",
            thumb = "https://www.themealdb.com/images/media/meals/t8mn9g1560460231.jpg",
        ),
        Favorite(
            id = "52959",
            name = "Baked salmon with fennel & tomatoes",
            thumb = "https://www.themealdb.com/images/media/meals/1548772327.jpg",
        ),
    )
    JetMealTheme {
        FavoritesContent(
            favorites = favorites,
            modifier = Modifier.fillMaxWidth(),
            onShareButtonClicked = {},
            navigateToDetail = {}
        )
    }
}