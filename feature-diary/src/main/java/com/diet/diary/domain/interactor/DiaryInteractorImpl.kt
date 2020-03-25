package com.diet.diary.domain.interactor

import com.abecerra.base.domain.BaseInteractorImpl
import com.abecerra.base.utils.calculatePercent
import com.diet.diary.domain.model.Diary
import com.diet.diary.domain.repository.DiaryRepository
import com.diet.diary.domain.repository.DiaryRepositoryOutput

class DiaryInteractorImpl(private val DiaryRepository: DiaryRepository) :
    BaseInteractorImpl<DiaryInteractorOutput>(), DiaryInteractor, DiaryRepositoryOutput {

    init {
        DiaryRepository.setRepositoryOutput(this)
    }

    override fun getCurrentDayDiary() {
        DiaryRepository.getCurrentDayDiary()
    }

    override fun onSuccessFetchUserdiary(model: Diary) {
        fillPercents(model)
        output?.onSuccessFetchUserdiary(model)
    }

    override fun onErrorFetchUserdiary() {
        output?.onErrorFetchUserdiary()
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