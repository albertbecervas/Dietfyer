package com.diet.network.diary.model

import com.diet.network.food.model.MacronutrientsDto

data class GoalsDto(
    val calories: Int = 0,
    val macronutrients: MacronutrientsDto = MacronutrientsDto()
)