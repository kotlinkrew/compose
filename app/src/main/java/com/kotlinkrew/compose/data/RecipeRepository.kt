package com.kotlinkrew.compose.data

import kotlinx.coroutines.flow.flowOf

/**
 * @author Ryan Simon
 **/
fun recipeList() = flowOf(listOf(
    Recipe(id = 1, title = "Lasagna", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
    Recipe(id = 2, title = "Pizza", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
    Recipe(id = 3, title = "Vanilla Ice Cream", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
    Recipe(id = 4, title = "Snickerdoodle Cookies", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
    Recipe(id = 5, title = "Ricotta Pancakes", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
    Recipe(id = 6, title = "Chocolate Cake", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
    Recipe(id = 7, title = "Lasagna", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
    Recipe(id = 8, title = "Pizza", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
    Recipe(id = 9, title = "Vanilla Ice Cream", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
    Recipe(id = 10, title = "Snickerdoodle Cookies", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
    Recipe(id = 11, title = "Ricotta Pancakes", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
    Recipe(id = 12, title = "Chocolate Cake", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
    Recipe(id = 13, title = "Lasagna", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
    Recipe(id = 14, title = "Pizza", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
    Recipe(id = 15, title = "Vanilla Ice Cream", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
    Recipe(id = 16, title = "Snickerdoodle Cookies", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = ""),
))

fun sampleRecipe() = Recipe(id = 100, title = "Lasagna", author = "John Doe", cookTime = "1 hr 30 min", imageUrl = "")
