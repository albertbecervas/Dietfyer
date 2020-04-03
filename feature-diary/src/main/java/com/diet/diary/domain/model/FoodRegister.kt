package com.diet.diary.domain.model

data class FoodRegister(
    val foodName: String,
    val calories: Int,
    val macronutrients: Macronutrients
)