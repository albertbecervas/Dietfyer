package com.diet.diary.presentation.presenter

import com.abecerra.base.presentation.BasePresenter
import com.diet.common.model.FoodRegisterViewModel
import com.diet.common.model.MealRegisterViewModel
import com.diet.diary.presentation.view.DiaryView

interface DiaryPresenter : BasePresenter<DiaryView> {
    fun getCurrentDaydiary()
    fun addFoodRegisterToMeal(mealRegisterList: List<MealRegisterViewModel>)
    fun addMeal(mealRegisterViewModel: MealRegisterViewModel)
}