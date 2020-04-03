package com.diet.network.diary.model

data class MealRegisterDto(val mealTitle: String = "", val foodRegister: List<FoodRegisterDto> = listOf())