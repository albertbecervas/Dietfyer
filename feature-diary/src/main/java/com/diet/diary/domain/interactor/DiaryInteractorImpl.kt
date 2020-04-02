package com.diet.diary.domain.interactor

import com.abecerra.base.domain.BaseInteractorImpl
import com.abecerra.base.utils.calculatePercent
import com.diet.diary.domain.model.Diary
import com.diet.diary.domain.model.FoodRegister
import com.diet.diary.domain.model.MealRegister
import com.diet.diary.domain.repository.DiaryRepository
import com.diet.diary.domain.repository.DiaryRepositoryOutput

class DiaryInteractorImpl(private val diaryRepository: DiaryRepository) :
    BaseInteractorImpl<DiaryInteractorOutput>(), DiaryInteractor, DiaryRepositoryOutput {

    init {
        diaryRepository.setRepositoryOutput(this)
    }

    override fun getCurrentDayDiary() {
        diaryRepository.getCurrentDayDiary()
    }

    override fun addFoodRegisterToMeal(mealRegisterList: List<MealRegister>) {
        diaryRepository.addFoodRegisterToMeal(mealRegisterList)
    }

    override fun addMeal(mealRegister: MealRegister) {
        diaryRepository.addMeal(mealRegister)
    }

    override fun onSuccessFetchUserdiary(model: Diary) {
        fillPercents(model)
        output?.onSuccessFetchUserdiary(model)
    }

    override fun onErrorFetchUserdiary() {
        output?.onErrorFetchUserdiary()
    }

    override fun onSuccessAddFoodRegister(mealRegisterList: List<MealRegister>) {
        output?.onSuccessAddFoodRegister(mealRegisterList)
    }

    override fun onErrorAddFoodRegister() {
        output?.onErrorAddFoodRegister()
    }

    override fun onSuccessAddMeal(meal: MealRegister) {
        output?.onSuccessAddMeal(meal)
    }

    override fun onErrorAddMeal() {
        output?.onErrorAddMeal()
    }

    private fun fillPercents(model: Diary) {
        with(model) {
            summary.caloriesPercent = calculatePercent(summary.calories, goals.calories)
            summary.macronutrients.proteinPercent =
                calculatePercent(summary.macronutrients.protein, goals.macronutrients.protein)
            summary.macronutrients.carbohydratesPercent = calculatePercent(
                summary.macronutrients.carbohydrates,
                goals.macronutrients.carbohydrates
            )
            summary.macronutrients.fatPercent =
                calculatePercent(summary.macronutrients.fat, goals.macronutrients.fat)
        }
    }
}