package com.diet.diary.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.abecerra.base.utils.DATE_ddMMYYYY_SLASH_FORMAT
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
import java.text.SimpleDateFormat
import java.util.*

class DiaryPresenterImpl(
    private val diaryRouter: DiaryRouter,
    private val diaryInteractor: DiaryInteractor
) : BasePresenterImpl<DiaryView>(),
    DiaryPresenter, DiaryInteractorOutput {

    init {
        diaryInteractor.setInteractorOutput(this)
    }

    var selectedDate: Date = Date()

    override fun getCurrentDaydiary() {
        getView()?.showProgressBar()
        diaryInteractor.getCurrentDayDiary()
    }

    override fun onAddFoodRegisterToMeal(mealRegisterList: List<MealRegisterViewModel>) {
        getView()?.showProgressBar()
        diaryInteractor.addFoodRegisterToMeal(
            selectedDate,
            mealRegisterList.map { it.toMealRegister() })
    }

    override fun onAddMealClick(mealRegisterViewModel: MealRegisterViewModel) {
        getView()?.showProgressBar()
        diaryInteractor.addMeal(selectedDate, mealRegisterViewModel.toMealRegister())
    }

    override fun onDateFilterChange(day: Int, month: Int, year: Int) {
        updateSelectedDate(day, month, year)
        getView()?.showProgressBar()
        updateToolbarTitle()
        diaryInteractor.getDiaryByDate(day, month, year)
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

    private fun updateSelectedDate(day: Int, month: Int, year: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        selectedDate = calendar.time
    }

    private fun updateToolbarTitle() {
        val selectedDateCalendar = Calendar.getInstance()
        selectedDateCalendar.time = selectedDate
        val currentDateCalendar = Calendar.getInstance()
        if (selectedDateCalendar.get(Calendar.YEAR) == currentDateCalendar.get(Calendar.YEAR) && selectedDateCalendar.get(
                Calendar.MONTH
            ) == currentDateCalendar.get(Calendar.MONTH) && selectedDateCalendar.get(Calendar.DAY_OF_MONTH) == currentDateCalendar.get(
                Calendar.DAY_OF_MONTH
            )
        ) {
            getView()?.setTodaySelectedDate()
        }
        else {
            val dateFormat = SimpleDateFormat.getDateInstance()
            getView()?.setSelectedDate(dateFormat.format(selectedDateCalendar.time))
        }
    }

}