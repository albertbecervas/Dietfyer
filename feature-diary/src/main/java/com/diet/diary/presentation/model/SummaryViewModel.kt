package com.diet.diary.presentation.model

import com.diet.common.model.MacronutrientsViewModel

data class SummaryViewModel(
    val calories: Int,
    val caloriesPercent : Int,
    val macronutrients: MacronutrientsViewModel
)