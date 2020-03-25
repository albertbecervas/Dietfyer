package com.diet.network.dairy.model

import com.diet.network.food.model.MacronutrientsDto

data class FoodRegisterDto(
    val foodId: String = "",
    val calories: Int = 0,
    val macronutrients: MacronutrientsDto = MacronutrientsDto()
)