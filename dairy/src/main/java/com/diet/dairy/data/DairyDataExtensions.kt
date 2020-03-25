package com.diet.dairy.data

import com.diet.dairy.domain.model.*
import com.diet.network.dairy.model.DairyDto
import com.diet.network.dairy.model.FoodRegisterDto
import com.diet.network.dairy.model.GoalsDto
import com.diet.network.dairy.model.SummaryDto
import com.diet.network.food.model.MacronutrientsDto

internal fun MacronutrientsDto.toMacronutrients(): Macronutrients {
    return Macronutrients(protein, carbohydrates, fat)
}

internal fun SummaryDto.toSummary(): Summary {
    return Summary(calories, macronutrients = macronutrients.toMacronutrients())
}

internal fun FoodRegisterDto.toFoodRegister(): FoodRegister {
    return FoodRegister(
        foodId = foodId,
        calories = calories,
        macronutrients = macronutrients.toMacronutrients()
    )
}

internal fun GoalsDto.toGoals(): Goals {
    return Goals(calories = calories, macronutrients = macronutrients.toMacronutrients())
}

internal fun DairyDto.toDairy(): Dairy {
    return Dairy(
        summary = summaryDto.toSummary(),
        foodRegister = foodRegisterDto.map { it.toFoodRegister() },
        goals = goalsDto.toGoals()
    )
}