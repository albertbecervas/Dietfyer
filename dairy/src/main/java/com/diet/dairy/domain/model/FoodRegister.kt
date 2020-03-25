package com.diet.dairy.domain.model

data class FoodRegister(
    val foodId: String,
    val calories: Int,
    val macronutrients: Macronutrients
)