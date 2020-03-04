package com.abecerra.core.scenes.main.presentation.presenter

import com.abecerra.base.presentation.BasePresenter
import com.abecerra.core.scenes.main.presentation.view.MainView

interface MainPresenter : BasePresenter<MainView> {

    fun loadDefaultFragment()
}