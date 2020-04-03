package com.diet.diary.presentation

import com.diet.common.model.FoodRegisterViewModel
import com.diet.common.model.MacronutrientsViewModel
import com.diet.common.model.MealRegisterViewModel
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

internal fun MacronutrientsViewModel.toMacronutrients(): Macronutrients {
    return Macronutrients(
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
        foodName = foodName,
        calories = calories,
        macronutrients = macronutrients.toMacronutrientsViewModel()
    )
}

internal fun FoodRegisterViewModel.toFoodRegister(): FoodRegister {
    return FoodRegister(
        foodName = foodName,
        calories = calories,
        macronutrients = macronutrients.toMacronutrients()
    )
}

internal fun Diary.toDiaryViewModel(): DiaryViewModel {
    return DiaryViewModel(
        summary = summary.toSummaryViewModel(),
        mealRegister = mealRegister.map { it.toMealRegisterViewModel() },
        goals = goals.toGoalsViewModel()
    )
}

internal fun Goals.toGoalsViewModel(): GoalsViewModel {
    return GoalsViewModel(
        calories = calories,
        macronutrients = macronutrients.toMacronutrientsViewModel()
    )
}

internal fun MealRegister.toMealRegisterViewModel(): MealRegisterViewModel {
    return MealRegisterViewModel(
        mealTitle = mealTitle,
        foodRegister = foodRegister.map { item -> item.toFoodRegisterViewModel() }.toMutableList(),
        total = total.toMacronutrientsViewModel()
    )
}

internal fun MealRegisterViewModel.toMealRegister(): MealRegister {
    return MealRegister(
        mealTitle = mealTitle,
        foodRegister = foodRegister.map { item -> item.toFoodRegister() },
        total = total.toMacronutrients()
    )
}