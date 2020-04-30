package com.diet.diary.data

import com.abecerra.base.data.BaseRepositoryImpl
import com.diet.diary.domain.model.MealRegister
import com.diet.diary.domain.repository.DiaryRepository
import com.diet.diary.domain.repository.DiaryRepositoryOutput
import com.diet.network.diary.DiaryService
import com.diet.session.user.data.UserDataSource
import java.util.*

class DiaryRepositoryImpl(
    private val userDataSource: UserDataSource,
    private val diaryService: DiaryService
) : BaseRepositoryImpl<DiaryRepositoryOutput>(), DiaryRepository {

    override fun getCurrentDayDiary() {
        diaryService.getDiary(
            userDataSource.getCurrentUserId(),
            { output?.onSuccessFetchUserdiary(it.toDiary()) },
            { output?.onErrorFetchUserdiary() })
    }

    override fun getDiaryByDate(date: Date) {
        diaryService.getDiary(
            userDataSource.getCurrentUserId(),
            date,
            { output?.onSuccessFetchUserdiary(it.toDiary()) },
            { output?.onErrorFetchUserdiary() })
    }

    override fun addFoodRegisterToMeal(date: Date, mealRegisterList: List<MealRegister>) {
        diaryService.addFoodRegisterToMeal(
            mealRegisterList.map {
                it.toMealRegisterDto()
            },
            userDataSource.getCurrentUserId(),
            date,
            { output?.onSuccessAddFoodRegister(mealRegisterList) },
            { output?.onErrorAddMeal() })
    }


    override fun addMeal(date: Date, mealRegister: MealRegister) {
        diaryService.addMeal(
            mealRegister.toMealRegisterDto(),
            userDataSource.getCurrentUserId(),
            date,
            { output?.onSuccessAddMeal(mealRegister) },
            { output?.onErrorAddMeal() })
    }

}