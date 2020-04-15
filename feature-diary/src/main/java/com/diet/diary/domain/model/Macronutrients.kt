package com.diet.diary.domain.model

data class Macronutrients(
    val protein: Int,
    var proteinPercent: Int = 0,
    val carbohydrates: Int,
    var carbohydratesPercent: Int = 0,
    val fat: Int,
    var fatPercent: Int = 0
) {
    operator fun plus(macronutrients: Macronutrients): Macronutrients {
        return Macronutrients(
            protein = this.protein + macronutrients.protein,
            carbohydrates = this.carbohydrates + macronutrients.carbohydrates,
            fat = this.fat + macronutrients.fat
        )
    }
}