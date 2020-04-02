package com.diet.diary.data

import com.diet.diary.domain.model.*
import com.diet.network.diary.model.DiaryDto
import com.diet.network.diary.model.FoodRegisterDto
import com.diet.network.diary.model.GoalsDto
import com.diet.network.diary.model.SummaryDto
import com.diet.network.food.model.MacronutrientsDto

internal fun MacronutrientsDto.toMacronutrients(): Macronutrients {
    return Macronutrients(protein = protein, carbohydrates = carbohydrates, fat = fat)
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

internal fun DiaryDto.toDiary(): Diary {
    return Diary(
        summary = summaryDto.toSummary(),
        foodRegister = foodRegisterDto.map { it.toFoodRegister() },
        goals = goalsDto.toGoals()
    )
}