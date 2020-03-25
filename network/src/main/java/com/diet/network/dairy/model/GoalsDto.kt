package com.diet.network.dairy.model

import com.diet.network.food.model.MacronutrientsDto

data class GoalsDto(
    val calories: Int = 0,
    val macronutrients: MacronutrientsDto = MacronutrientsDto()
)