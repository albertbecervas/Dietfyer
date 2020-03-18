package com.diet.dietfyer.scenes.launcher.presenter

import com.abecerra.base.presentation.BasePresenter
import com.diet.dietfyer.scenes.launcher.view.LauncherView

interface LauncherPresenter : BasePresenter<LauncherView> {

    fun decideNavigation()
}