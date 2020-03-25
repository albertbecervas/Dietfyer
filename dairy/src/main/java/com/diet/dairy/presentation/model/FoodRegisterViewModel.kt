package com.diet.dairy.presentation.model

data class FoodRegisterViewModel(
    val foodId: String,
    val calories: Int,
    val macronutrients: MacronutrientsViewModel
)