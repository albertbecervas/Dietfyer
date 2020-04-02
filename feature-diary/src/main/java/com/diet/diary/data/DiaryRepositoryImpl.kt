package com.diet.diary.data

import com.abecerra.base.data.BaseRepositoryImpl
import com.diet.diary.domain.repository.DiaryRepository
import com.diet.diary.domain.repository.DiaryRepositoryOutput
import com.diet.network.diary.DiaryService
import com.diet.session.user.data.UserDataSource

class DiaryRepositoryImpl(
    private val userDataSource: UserDataSource,
    private val DiaryService: DiaryService
) : BaseRepositoryImpl<DiaryRepositoryOutput>(), DiaryRepository {

    override fun getCurrentDayDiary() {
        DiaryService.getDiary(
            userDataSource.getCurrentUserId(),
            { output?.onSuccessFetchUserdiary(it.toDiary()) },
            { output?.onErrorFetchUserdiary() })
    }

}