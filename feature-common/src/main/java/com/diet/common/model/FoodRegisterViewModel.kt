package com.diet.common.model

data class FoodRegisterViewModel(
    val foodName: String,
    val calories: Int,
    val macronutrients: MacronutrientsViewModel
)