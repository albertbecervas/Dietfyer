package com.diet.diary.domain.interactor

import com.abecerra.base.domain.BaseInteractor
import com.diet.diary.domain.model.FoodRegister
import com.diet.diary.domain.model.MealRegister
import java.util.*

interface DiaryInteractor : BaseInteractor<DiaryInteractorOutput> {
    fun getCurrentDayDiary()
    fun getDiaryByDate(day: Int, month: Int, year: Int)
    fun addFoodRegisterToMeal(date: Date, mealRegisterList: List<MealRegister>)
    fun addMeal(date: Date, mealRegister: MealRegister)
}