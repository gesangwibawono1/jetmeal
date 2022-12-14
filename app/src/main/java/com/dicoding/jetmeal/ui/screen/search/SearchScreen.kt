package com.dicoding.jetmeal.ui.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dicoding.jetmeal.di.Injection
import com.dicoding.jetmeal.model.Meal
import com.dicoding.jetmeal.R
import com.dicoding.jetmeal.ui.ViewModelFactory
import com.dicoding.jetmeal.ui.components.SearchBar
import com.dicoding.jetmeal.ui.components.SearchResultItem

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (String) -> Unit,
) {
    val meals by viewModel.meals.collectAsState()
    val query by viewModel.query
    
    Column {
        SearchBar(
            query = query,
            onQueryChange = viewModel::search,
            modifier = Modifier.background(MaterialTheme.colors.primary)
        )
        SearchContent(
            meals = meals,
            navigateToDetail = navigateToDetail
        )
    }
}

@Composable
fun SearchContent(
    meals: List<Meal>,
    modifier: Modifier = Modifier,
    navigateToDetail: (String) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        if (meals.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(160.dp),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = modifier.testTag("SearchResult")
            ) {
                items(meals) {
                    SearchResultItem(
                        thumb = it.thumb,
                        name = it.name,
                        price = it.price,
                        modifier = Modifier.clickable {
                            navigateToDetail(it.id)
                        }
                    )
                }
            }
        } else {
            Text(
                text = stringResource(R.string.no_result_search),
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
                    .testTag("NoDataMessage")
            )
        }
    }
}