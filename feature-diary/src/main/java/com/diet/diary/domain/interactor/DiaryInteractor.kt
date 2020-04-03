package com.diet.diary.domain.interactor

import com.abecerra.base.domain.BaseInteractor
import com.diet.diary.domain.model.FoodRegister
import com.diet.diary.domain.model.MealRegister

interface DiaryInteractor : BaseInteractor<DiaryInteractorOutput> {
    fun getCurrentDayDiary()
    fun addFoodRegisterToMeal(mealRegisterList: List<MealRegister>)
    fun addMeal(mealRegister: MealRegister)
}