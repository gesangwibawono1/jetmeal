package com.dicoding.jetmeal.ui.screen.search

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.dicoding.jetmeal.R
import com.dicoding.jetmeal.ui.theme.JetMealTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    val matchKeyword = "Beef"
    val unmatchKeyword = "Sausage"

    @Before
    fun setUp() {
        composeTestRule.setContent {
            JetMealTheme {
                SearchScreen(
                    navigateToDetail = {}
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }

    @Test
    fun search_with_match_keyword() {
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.placeholder_search))
            .performTextInput(matchKeyword)
        composeTestRule.onNodeWithTag("SearchResult").assertExists()
        composeTestRule.onNodeWithTag("NoDataMessage").assertDoesNotExist()
    }

    @Test
    fun search_with_unmatch_keyword() {
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.placeholder_search))
            .performTextInput(unmatchKeyword)
        composeTestRule.onNodeWithTag("SearchResult").assertDoesNotExist()
        composeTestRule.onNodeWithTag("NoDataMessage").assertExists()
    }


}