package com.diet.diary.domain.interactor

import com.diet.diary.domain.model.Diary

interface DiaryInteractorOutput {
    fun onSuccessFetchUserdiary(model: Diary)
    fun onErrorFetchUserdiary()
}