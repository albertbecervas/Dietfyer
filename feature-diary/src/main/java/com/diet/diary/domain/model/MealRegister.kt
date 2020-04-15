package com.diet.diary.domain.model

data class MealRegister(
    val mealTitle: String,
    val foodRegister: List<FoodRegister>,
    var total: Macronutrients,
    var totalCalories : Int = 0
)