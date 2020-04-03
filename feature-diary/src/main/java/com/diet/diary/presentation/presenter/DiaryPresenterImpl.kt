package com.diet.diary.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.diet.common.model.FoodRegisterViewModel
import com.diet.common.model.MealRegisterViewModel
import com.diet.diary.domain.interactor.DiaryInteractor
import com.diet.diary.domain.interactor.DiaryInteractorOutput
import com.diet.diary.domain.model.Diary
import com.diet.diary.domain.model.MealRegister
import com.diet.diary.presentation.router.DiaryRouter
import com.diet.diary.presentation.toDiaryViewModel
import com.diet.diary.presentation.toFoodRegister
import com.diet.diary.presentation.toMealRegister
import com.diet.diary.presentation.toMealRegisterViewModel
import com.diet.diary.presentation.view.DiaryView

class DiaryPresenterImpl(
    private val diaryRouter: DiaryRouter,
    private val diaryInteractor: DiaryInteractor
) : BasePresenterImpl<DiaryView>(),
    DiaryPresenter, DiaryInteractorOutput {

    init {
        diaryInteractor.setInteractorOutput(this)
    }

    override fun getCurrentDaydiary() {
        getView()?.showProgressBar()
        diaryInteractor.getCurrentDayDiary()
    }

    override fun addFoodRegisterToMeal(mealRegisterList: List<MealRegisterViewModel>) {
        getView()?.showProgressBar()
        diaryInteractor.addFoodRegisterToMeal(mealRegisterList.map { it.toMealRegister() })
    }

    override fun addMeal(mealRegisterViewModel: MealRegisterViewModel) {
        getView()?.showProgressBar()
        diaryInteractor.addMeal(mealRegisterViewModel.toMealRegister())
    }

    override fun onSuccessFetchUserdiary(model: Diary) {
        getView()?.hideProgressBar()
        getView()?.showDiary(model.toDiaryViewModel())
    }

    override fun onErrorFetchUserdiary() {
        getView()?.hideProgressBar()
        getView()?.showEmptyDiary()
    }

    override fun onSuccessAddFoodRegister(mealRegisterList: List<MealRegister>) {
        getView()?.hideProgressBar()
        getView()?.updateMealList(mealRegisterList.map { it.toMealRegisterViewModel() })
    }

    override fun onErrorAddFoodRegister() {
        TODO("Not yet implemented")
    }

    override fun onSuccessAddMeal(meal: MealRegister) {
        getView()?.hideProgressBar()
        getView()?.addMeal(meal.toMealRegisterViewModel())
    }

    override fun onErrorAddMeal() {
    }

}