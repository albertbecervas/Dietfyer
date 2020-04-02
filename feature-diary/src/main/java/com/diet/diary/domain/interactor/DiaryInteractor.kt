package com.diet.diary.domain.interactor

import com.abecerra.base.domain.BaseInteractor

interface DiaryInteractor : BaseInteractor<DiaryInteractorOutput> {
    fun getCurrentDayDiary()
}