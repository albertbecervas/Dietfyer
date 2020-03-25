package com.diet.dairy.presentation.model

data class DairyViewModel(
    val summary: SummaryViewModel,
    val foodRegister: List<FoodRegisterViewModel>,
    val goals: GoalsViewModel
)