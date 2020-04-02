package com.diet.diary.presentation.model

data class DiaryViewModel(
    val summary: SummaryViewModel,
    val foodRegister: List<FoodRegisterViewModel>,
    val goals: GoalsViewModel
)