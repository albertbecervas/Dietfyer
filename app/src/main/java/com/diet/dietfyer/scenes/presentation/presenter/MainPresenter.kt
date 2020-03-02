package com.diet.dietfyer.scenes.presentation.presenter

import com.abecerra.base.presentation.BasePresenter
import com.diet.dietfyer.scenes.presentation.view.MainView

interface MainPresenter : BasePresenter<MainView> {

    fun loadDefaultFragment()
}