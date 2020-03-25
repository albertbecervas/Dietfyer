package com.diet.dairy.presentation.view

import com.abecerra.base.presentation.BaseView
import com.diet.dairy.presentation.model.DairyViewModel
import com.diet.network.dairy.model.DairyDto

interface DairyView : BaseView {
    fun showDairy(dairy : DairyViewModel)
}