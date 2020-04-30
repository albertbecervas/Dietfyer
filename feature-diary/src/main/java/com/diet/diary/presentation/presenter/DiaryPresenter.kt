package com.diet.diary.presentation.presenter

import com.abecerra.base.presentation.BasePresenter
import com.diet.common.model.FoodRegisterViewModel
import com.diet.common.model.MealRegisterViewModel
import com.diet.diary.presentation.view.DiaryView

interface DiaryPresenter : BasePresenter<DiaryView> {
    fun getCurrentDaydiary()
    fun onAddFoodRegisterToMeal(mealRegisterList: List<MealRegisterViewModel>)
    fun onAddMealClick(mealRegisterViewModel: MealRegisterViewModel)
    fun onDateFilterChange(day: Int, month: Int, year: Int)
}