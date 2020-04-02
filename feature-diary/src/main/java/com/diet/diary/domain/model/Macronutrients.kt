package com.diet.diary.domain.model

data class Macronutrients(
    val protein: Int,
    var proteinPercent: Int = 0,
    val carbohydrates: Int,
    var carbohydratesPercent: Int = 0,
    val fat: Int,
    var fatPercent: Int = 0
)