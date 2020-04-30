package com.diet.diary.presentation.view

import com.abecerra.base.presentation.BaseView
import com.diet.common.model.MealRegisterViewModel
import com.diet.diary.presentation.model.DiaryViewModel

interface DiaryView : BaseView {
    fun showDiary(diary: DiaryViewModel)
    fun showEmptyDiary()
    fun updateMealList(mealRegisterList: List<MealRegisterViewModel>)
    fun addMeal(meal: MealRegisterViewModel)
    fun setSelectedDate(format: String)
    fun setTodaySelectedDate()
}