package com.diet.diary.domain.model

data class MealRegister(
    val mealTitle: String,
    val foodRegister: List<FoodRegister>,
    val total: Macronutrients
)