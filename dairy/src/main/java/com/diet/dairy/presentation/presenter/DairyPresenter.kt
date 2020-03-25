package com.diet.dairy.presentation.presenter

import com.abecerra.base.presentation.BasePresenter
import com.diet.dairy.presentation.view.DairyView

interface DairyPresenter : BasePresenter<DairyView> {
    fun getCurrentDayDairy()
}