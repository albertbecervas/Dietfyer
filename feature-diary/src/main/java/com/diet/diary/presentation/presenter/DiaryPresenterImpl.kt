package com.diet.diary.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.diet.diary.domain.interactor.DiaryInteractor
import com.diet.diary.domain.interactor.DiaryInteractorOutput
import com.diet.diary.domain.model.Diary
import com.diet.diary.presentation.router.DiaryRouter
import com.diet.diary.presentation.todiaryViewModel
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

    override fun onSuccessFetchUserdiary(model: Diary) {
        getView()?.hideProgressBar()
        getView()?.showDiary(model.todiaryViewModel())
    }

    override fun onErrorFetchUserdiary() {
        getView()?.hideProgressBar()
        getView()?.showEmptyDiary()
    }

}