package com.diet.diary.presentation.model

import com.diet.common.model.MacronutrientsViewModel


data class GoalsViewModel(
    val calories: Int,
    val macronutrients: MacronutrientsViewModel
)