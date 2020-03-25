package com.diet.diary.presentation

import com.diet.diary.domain.model.*
import com.diet.diary.presentation.model.*

internal fun Macronutrients.toMacronutrientsViewModel(): MacronutrientsViewModel {
    return MacronutrientsViewModel(
        protein,
        proteinPercent,
        carbohydrates,
        carbohydratesPercent,
        fat,
        fatPercent
    )
}

internal fun Summary.toSummaryViewModel(): SummaryViewModel {
    return SummaryViewModel(
        calories = calories,
        caloriesPercent = caloriesPercent,
        macronutrients = macronutrients.toMacronutrientsViewModel()
    )
}

internal fun FoodRegister.toFoodRegisterViewModel(): FoodRegisterViewModel {
    return FoodRegisterViewModel(
        foodId = foodId,
        calories = calories,
        macronutrients = macronutrients.toMacronutrientsViewModel()
    )
}

internal fun Diary.todiaryViewModel(): DiaryViewModel {
    return DiaryViewModel(
        summary = summary.toSummaryViewModel(),
        foodRegister = foodRegister.map { it.toFoodRegisterViewModel() },
        goals = goals.toGoalsViewModel()
    )
}

internal fun Goals.toGoalsViewModel(): GoalsViewModel {
    return GoalsViewModel(
        calories = calories,
        macronutrients = macronutrients.toMacronutrientsViewModel()
    )
}