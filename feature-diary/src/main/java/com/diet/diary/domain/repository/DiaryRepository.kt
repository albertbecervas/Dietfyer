package com.diet.diary.domain.repository

import com.abecerra.base.data.BaseRepository
import com.diet.diary.domain.model.FoodRegister
import com.diet.diary.domain.model.MealRegister
import com.diet.network.diary.model.MealRegisterDto
import java.util.*

interface DiaryRepository : BaseRepository<DiaryRepositoryOutput> {
    fun getCurrentDayDiary()
    fun getDiaryByDate(date: Date)
    fun addFoodRegisterToMeal(date: Date, mealRegisterList: List<MealRegister>)
    fun addMeal(date: Date, mealRegister: MealRegister)
}