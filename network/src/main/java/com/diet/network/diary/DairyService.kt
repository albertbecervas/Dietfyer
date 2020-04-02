package com.diet.network.diary

import com.diet.network.diary.model.DiaryDto
import com.diet.network.diary.model.FoodRegisterDto
import com.diet.network.diary.model.MealRegisterDto
import java.util.*

interface DiaryService {

    fun getDiary(userId: String, success: (diaryDto: DiaryDto) -> Unit, error: () -> Unit)

    fun getDiary(
        userId: String,
        date: Date,
        success: (diaryDto: DiaryDto) -> Unit,
        error: () -> Unit
    )

    fun addFoodRegisterToMeal(
        mealRegisterDtoList: List<MealRegisterDto>,
        userId: String,
        success: () -> Unit,
        error: () -> Unit
    )

    fun addMeal(
        mealRegisterDto: MealRegisterDto,
        userId: String,
        success: () -> Unit,
        error: () -> Unit
    )
}