package com.kotlinkrew.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign.Start
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.kotlinkrew.compose.data.Recipe
import com.kotlinkrew.compose.data.recipeList
import com.kotlinkrew.compose.data.sampleRecipe
import com.kotlinkrew.compose.ui.ComposeTheme
import kotlinx.coroutines.flow.Flow

class MainActivity : AppCompatActivity() {

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

/**
 * Goals:
 * 1. Simple List
 * 2. Simple Animation
 * 3. Detail view from List
 * 4. Populate list using LiveData/Flow
 */

val colors = listOf(
    Color(0xFFffd7d7.toInt()),
    Color(0xFFffe9d6.toInt()),
    Color(0xFFfffbd0.toInt()),
    Color(0xFFe3ffd9.toInt()),
    Color(0xFFd0fff8.toInt())
)

@ExperimentalAnimationApi
@Composable
fun RecipeItemList(recipeListFlow: Flow<List<Recipe>>) {
    val recipeListState = recipeListFlow.collectAsState(initial = emptyList())
    val deletedRecipeList = remember { mutableStateListOf<Recipe>() }

    LazyColumnForIndexed(items = recipeListState.value, modifier = Modifier.fillMaxHeight()) { index, recipe ->
        AnimatedVisibility(
            visible = !deletedRecipeList.contains(recipe),
            enter = expandVertically(),
            exit = shrinkVertically(
                animSpec = tween(
                    durationMillis = 1000,
                )
            ),
            modifier = Modifier.fillParentMaxWidth()
        ) {
            RecipeListItemWithDivider(
                backgroundColor = colors[index % colors.size],
                recipe = recipe,
                shouldHaveDivider = index < recipeListState.value.size - 1,
                onDelete = { deletedRecipeList.add(recipe) }
            )
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun MainContent() {
    ComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Column {
                RecipeItemList(recipeListFlow = recipeList())
            }
        }
    }
}

@Composable
fun RecipeListItemWithDivider(backgroundColor: Color, recipe: Recipe, shouldHaveDivider: Boolean, onDelete: () -> Unit) {
    Column {
        RecipeListItem(
            backgroundColor = backgroundColor,
            recipe = recipe,
            onDelete = onDelete
        )

        if (shouldHaveDivider) {
            Divider(color = Color.Black, thickness = 1.dp)
        }
    }
}

@Composable
fun RecipeListItem(backgroundColor: Color, recipe: Recipe, onDelete: () -> Unit) {
    Card(
        shape = RoundedCornerShape(4.dp),
        backgroundColor = backgroundColor,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row {
            Text(
                recipe.title,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    textAlign = Start
                ),
                modifier = Modifier.padding(16.dp).weight(weight = 1F)
            )

            IconButton(onClick = onDelete, modifier = Modifier.align(Alignment.CenterVertically)) {
                Icon(Filled.Delete)
            }
        }
    }
}

@Preview(name = "Recipe List Item")
@Composable
fun RecipeListItemPreview() {
    RecipeListItem(backgroundColor = Color.White, recipe = sampleRecipe(), onDelete = {})
}

@ExperimentalAnimationApi
@Preview
@Composable
fun ListPreview() {
    RecipeItemList(recipeList())
}



