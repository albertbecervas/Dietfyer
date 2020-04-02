package com.diet.diary.presentation.view

import com.abecerra.base.presentation.BaseView
import com.diet.diary.presentation.model.DiaryViewModel

interface DiaryView : BaseView {
    fun showDiary(diary: DiaryViewModel)
    fun showEmptyDiary()
}