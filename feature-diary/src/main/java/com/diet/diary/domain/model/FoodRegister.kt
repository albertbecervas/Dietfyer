package com.diet.diary.domain.model

data class FoodRegister(
    val foodId: String,
    val calories: Int,
    val macronutrients: Macronutrients
)