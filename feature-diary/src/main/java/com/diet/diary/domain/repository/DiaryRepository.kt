package com.diet.diary.domain.repository

import com.abecerra.base.data.BaseRepository

interface DiaryRepository : BaseRepository<DiaryRepositoryOutput> {
    fun getCurrentDayDiary()
}