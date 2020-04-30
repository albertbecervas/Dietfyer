package com.diet.diary.domain.interactor

import com.abecerra.base.domain.BaseInteractorImpl
import com.abecerra.base.utils.calculatePercent
import com.diet.diary.domain.model.Diary
import com.diet.diary.domain.model.Macronutrients
import com.diet.diary.domain.model.MealRegister
import com.diet.diary.domain.repository.DiaryRepository
import com.diet.diary.domain.repository.DiaryRepositoryOutput
import java.util.*

class DiaryInteractorImpl(private val diaryRepository: DiaryRepository) :
    BaseInteractorImpl<DiaryInteractorOutput>(), DiaryInteractor, DiaryRepositoryOutput {

    init {
        diaryRepository.setRepositoryOutput(this)
    }

    override fun getCurrentDayDiary() {
        diaryRepository.getCurrentDayDiary()
    }

    override fun getDiaryByDate(day: Int, month: Int, year: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year,month,day)
        diaryRepository.getDiaryByDate(calendar.time)
    }

    override fun addFoodRegisterToMeal(date: Date, mealRegisterList: List<MealRegister>) {
        diaryRepository.addFoodRegisterToMeal(date,mealRegisterList)
    }

    override fun addMeal(date: Date, mealRegister: MealRegister) {
        diaryRepository.addMeal(date,mealRegister)
    }

    override fun onSuccessFetchUserdiary(model: Diary) {
        fillPercents(model)
        fillTotals(model)
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

    private fun fillTotals(model: Diary) {
        with(model.mealRegister) {
            forEach { mealRegister ->
                mealRegister.foodRegister.forEach {
                    mealRegister.total += it.macronutrients
                    mealRegister.totalCalories += it.calories
                }
            }
        }
    }
}