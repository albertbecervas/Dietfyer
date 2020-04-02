package com.diet.diary.domain.repository

import com.abecerra.base.data.BaseRepository
import com.diet.diary.domain.model.FoodRegister
import com.diet.diary.domain.model.MealRegister
import com.diet.network.diary.model.MealRegisterDto

interface DiaryRepository : BaseRepository<DiaryRepositoryOutput> {
    fun getCurrentDayDiary()
    fun addFoodRegisterToMeal(mealRegisterList: List<MealRegister>)
    fun addMeal(mealRegister: MealRegister)
}