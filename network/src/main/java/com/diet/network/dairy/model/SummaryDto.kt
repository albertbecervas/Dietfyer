package com.diet.network.dairy.model

import com.diet.network.food.model.MacronutrientsDto

data class SummaryDto(
    val calories: Int = 0,
    val macronutrients: MacronutrientsDto = MacronutrientsDto()
)