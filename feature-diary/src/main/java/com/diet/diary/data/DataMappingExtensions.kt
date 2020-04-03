package com.diet.diary.data

import com.diet.diary.domain.model.*
import com.diet.network.diary.model.*
import com.diet.network.food.model.MacronutrientsDto

internal fun MacronutrientsDto.toMacronutrients(): Macronutrients {
    return Macronutrients(protein = protein, carbohydrates = carbohydrates, fat = fat)
}

internal fun Macronutrients.toMacronutrientsDto(): MacronutrientsDto {
    return MacronutrientsDto(protein = protein, carbohydrates = carbohydrates, fat = fat)
}

internal fun SummaryDto.toSummary(): Summary {
    return Summary(calories, macronutrients = macronutrients.toMacronutrients())
}

internal fun FoodRegisterDto.toFoodRegister(): FoodRegister {
    return FoodRegister(
        foodName = foodName,
        calories = calories,
        macronutrients = macronutrients.toMacronutrients()
    )
}

internal fun FoodRegister.toFoodRegisterDto(): FoodRegisterDto {
    return FoodRegisterDto(
        foodName = foodName,
        calories = calories,
        macronutrients = macronutrients.toMacronutrientsDto()
    )
}

internal fun GoalsDto.toGoals(): Goals {
    return Goals(calories = calories, macronutrients = macronutrients.toMacronutrients())
}

internal fun DiaryDto.toDiary(): Diary {
    return Diary(
        summary = summaryDto.toSummary(),
        mealRegister = mealRegisterDto.map { it.toMealRegister() },
        goals = goalsDto.toGoals()
    )
}

internal fun MealRegisterDto.toMealRegister(): MealRegister {
    return MealRegister(
        mealTitle = mealTitle,
        foodRegister = foodRegister.map { item -> item.toFoodRegister() },
        total = Macronutrients(protein = 0, carbohydrates = 0, fat = 0)
    )
}

internal fun MealRegister.toMealRegisterDto(): MealRegisterDto {
    return MealRegisterDto(
        mealTitle = mealTitle,
        foodRegister = foodRegister.map { item -> item.toFoodRegisterDto() }
    )
}
