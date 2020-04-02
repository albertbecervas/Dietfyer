package com.diet.diary.presentation.presenter

import com.abecerra.base.presentation.BasePresenter
import com.diet.diary.presentation.view.DiaryView

interface DiaryPresenter : BasePresenter<DiaryView> {
    fun getCurrentDaydiary()
}