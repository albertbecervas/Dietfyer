package com.diet.dairy.domain.repository

import com.abecerra.base.data.BaseRepository

interface DairyRepository : BaseRepository<DairyRepositoryOutput> {
    fun getCurrentDayDairy()
}