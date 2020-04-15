package com.diet.common.model

data class MealRegisterViewModel(
    val mealTitle: String,
    var foodRegister: MutableList<FoodRegisterViewModel>,
    var total: MacronutrientsViewModel,
    var totalCalories : Int
)