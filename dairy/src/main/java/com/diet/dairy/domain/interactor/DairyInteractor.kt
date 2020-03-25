package com.diet.dairy.domain.interactor

import com.abecerra.base.domain.BaseInteractor

interface DairyInteractor : BaseInteractor<DairyInteractorOutput> {
    fun getCurrentDayDairy()
}