package com.diet.diary.presentation.model

import com.diet.common.model.MealRegisterViewModel

data class DiaryViewModel(
    val summary: SummaryViewModel,
    val mealRegister: List<MealRegisterViewModel>,
    val goals: GoalsViewModel
)