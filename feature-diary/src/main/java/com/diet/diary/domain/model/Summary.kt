package com.diet.diary.domain.model

data class Summary(val calories: Int, var caloriesPercent: Int = 0, val macronutrients: Macronutrients)