package com.diet.diary.domain.repository

import com.diet.diary.domain.model.Diary
import com.diet.diary.domain.model.MealRegister

interface DiaryRepositoryOutput {

    fun onSuccessFetchUserdiary(model: Diary)
    fun onErrorFetchUserdiary()
    fun onSuccessAddFoodRegister(mealRegisterList: List<MealRegister>)
    fun onErrorAddFoodRegister()
    fun onSuccessAddMeal(meal: MealRegister)
    fun onErrorAddMeal()

}