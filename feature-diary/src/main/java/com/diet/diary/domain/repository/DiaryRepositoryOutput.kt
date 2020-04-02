package com.diet.diary.domain.repository

import com.diet.diary.domain.model.Diary

interface DiaryRepositoryOutput {

    fun onSuccessFetchUserdiary(model : Diary)
    fun onErrorFetchUserdiary()

}