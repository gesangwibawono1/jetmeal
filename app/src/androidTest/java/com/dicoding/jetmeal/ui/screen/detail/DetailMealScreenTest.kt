package com.dicoding.jetmeal.ui.screen.detail

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.dicoding.jetmeal.model.Area
import com.dicoding.jetmeal.model.Category
import com.dicoding.jetmeal.model.Ingredient
import com.dicoding.jetmeal.model.MealDetail
import com.dicoding.jetmeal.ui.theme.JetMealTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailMealScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private val fakeMealDetail = MealDetail(
        id = "52874",
        name = "Beef and Mustard Pie",
        thumb = "https://www.themealdb.com/images/media/meals/sytuqu1511553755.jpg",
        price = 5,
        tags = listOf("Meat", "Pie"),
        area = Area.BRITISH,
        category = Category.BEEF,
        ingredients = listOf(
            Ingredient(name = "Beef", quantity = 1.0, unit = "kg"),
            Ingredient(name = "Plain Flour", quantity = 2.0, unit = "tbs"),
            Ingredient(name = "Rapeseed Oil", quantity = 2.0, unit = "tbs"),
            Ingredient(name = "Red Wine", quantity = 200.0, unit = "ml"),
            Ingredient(name = "Beef Stock", quantity = 400.0, unit = "ml"),
            Ingredient(name = "Onion", quantity = 1.0, unit = "finely sliced"),
            Ingredient(name = "Carrots", quantity = 2.0, unit = "chopped"),
            Ingredient(name = "Thyme", quantity = 3.0, unit = "sprigs"),
            Ingredient(name = "Mustard", quantity = 2.0, unit = "tbs"),
            Ingredient(name = "Egg Yolks", quantity = 2.0, unit = "free-range"),
            Ingredient(name = "Pass Pastry", quantity = 400.0, unit = "g"),
            Ingredient(name = "Green Beans", quantity = 300.0, unit = "g"),
            Ingredient(name = "Butter", quantity = 25.0, unit = "g"),
            Ingredient(name = "Salt", quantity = 1.0, unit = "pinch"),
            Ingredient(name = "Pepper", quantity = 1.0, unit = "pinch"),
        ),
        instruction = "Preheat the oven to 150C/300F/Gas 2. Toss the beef and flour together in a bowl with some salt and black pepper. Heat a large casserole until hot, add half of the rapeseed oil and enough of the beef to just cover the bottom of the casserole. Fry until browned on each side, then remove and set aside. Repeat with the remaining oil and beef. Return the beef to the pan, add the wine and cook until the volume of liquid has reduced by half, then add the stock, onion, carrots, thyme and mustard, and season well with salt and pepper. Cover with a lid and place in the oven for two hours. Remove from the oven, check the seasoning and set aside to cool. Remove the thyme. When the beef is cool and you're ready to assemble the pie, preheat the oven to 200C/400F/Gas 6. Transfer the beef to a pie dish, brush the rim with the beaten egg yolks and lay the pastry over the top. Brush the top of the pastry with more beaten egg. Trim the pastry so there is just enough excess to crimp the edges, then place in the oven and bake for 30 minutes, or until the pastry is golden-brown and cooked through. For the green beans, bring a saucepan of salted water to the boil, add the beans and cook for 4-5 minutes, or until just tender. Drain and toss with the butter, then season with black pepper. To serve, place a large spoonful of pie onto each plate with some green beans alongside."
    )

    @Before
    fun setUp() {
        composeTestRule.setContent {
            JetMealTheme {
                DetailMealContent(
                    mealDetail = fakeMealDetail,
                    onBackClick = {},
                    onFavoriteToggle = {},
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }

    @Test
    fun detailMealContent_isDisplayed() {
        composeTestRule.onNodeWithText(fakeMealDetail.name).assertIsDisplayed()
    }
}