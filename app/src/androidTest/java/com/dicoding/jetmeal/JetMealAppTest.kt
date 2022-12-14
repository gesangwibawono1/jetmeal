package com.dicoding.jetmeal

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.dicoding.jetmeal.data.FakeMealDataSource
import com.dicoding.jetmeal.ui.navigation.Screen
import com.dicoding.jetmeal.ui.theme.JetMealTheme
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class JetMealAppTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            JetMealTheme {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())
                JetMealApp(navController = navController)
            }
        }
    }

    @Test
    fun navHost_verifyStartDestination() {
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        assertEquals(Screen.Search.route, currentRoute)
    }

    @Test
    fun navHost_clickItem_navigatesToDetailMealWithData() {
        composeTestRule.onNodeWithTag("SearchResult").performScrollToIndex(10)
        composeTestRule.onNodeWithText(FakeMealDataSource.dummyMeals[10].name).performClick()
        navController.assertCurrentRouteName(Screen.DetailMeal.route)
        composeTestRule.onNodeWithText(FakeMealDataSource.dummyMeals[10].name).assertIsDisplayed()
    }

    @Test
    fun navHost_bottomNavigation_working() {
        composeTestRule.onNodeWithStringId(R.string.menu_favorites).performClick()
        navController.assertCurrentRouteName(Screen.Favorites.route)
        composeTestRule.onNodeWithStringId(R.string.menu_profile).performClick()
        navController.assertCurrentRouteName(Screen.Profile.route)
        composeTestRule.onNodeWithStringId(R.string.menu_search).performClick()
        navController.assertCurrentRouteName(Screen.Search.route)
    }

    @Test
    fun navHost_clickItem_navigatesBack() {
        composeTestRule.onNodeWithTag("SearchResult").performScrollToIndex(10)
        composeTestRule.onNodeWithText(FakeMealDataSource.dummyMeals[10].name).performClick()
        navController.assertCurrentRouteName(Screen.DetailMeal.route)
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.back)).performClick()
        navController.assertCurrentRouteName(Screen.Search.route)
    }

    @Test
    fun navHost_addOrRemoveFavorite_rightBackStack() {
        composeTestRule.onNodeWithText(FakeMealDataSource.dummyMeals[1].name).performClick()
        navController.assertCurrentRouteName(Screen.DetailMeal.route)
        composeTestRule.onNodeWithTag("FavoriteToggle").performClick()
        navController.assertCurrentRouteName(Screen.Favorites.route)
        composeTestRule.onNodeWithStringId(R.string.menu_search).performClick()
        navController.assertCurrentRouteName(Screen.Search.route)
    }
}