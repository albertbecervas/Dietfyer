package com.diet.dietfyer.scenes.fullscreen.presenter

import com.abecerra.base.presentation.BasePresenter
import com.diet.dietfyer.scenes.fullscreen.view.LauncherView

interface LauncherPresenter : BasePresenter<LauncherView> {

    fun decideNavigation()
}