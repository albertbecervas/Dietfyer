package com.diet.dairy.presentation

import com.diet.dairy.domain.model.*
import com.diet.dairy.presentation.model.*

internal fun Macronutrients.toMacronutrientsViewModel(): MacronutrientsViewModel {
    return MacronutrientsViewModel(protein, carbohydrates, fat)
}

internal fun Summary.toSummaryViewModel(): SummaryViewModel {
    return SummaryViewModel(calories, macronutrients = macronutrients.toMacronutrientsViewModel())
}

internal fun FoodRegister.toFoodRegisterViewModel(): FoodRegisterViewModel {
    return FoodRegisterViewModel(
        foodId = foodId,
        calories = calories,
        macronutrients = macronutrients.toMacronutrientsViewModel()
    )
}

internal fun Dairy.toDairyViewModel(): DairyViewModel {
    return DairyViewModel(
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