package com.diet.diary.presentation.model

data class SummaryViewModel(
    val calories: Int,
    val caloriesPercent : Int,
    val macronutrients: MacronutrientsViewModel
)