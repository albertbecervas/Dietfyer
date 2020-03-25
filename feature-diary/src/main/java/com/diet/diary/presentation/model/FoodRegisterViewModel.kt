package com.diet.diary.presentation.model

data class FoodRegisterViewModel(
    val foodId: String,
    val calories: Int,
    val macronutrients: MacronutrientsViewModel
)