package com.diet.dietfyer.scenes.fullscreen.presenter

import android.os.Handler
import com.abecerra.base.presentation.BasePresenterImpl
import com.diet.dietfyer.scenes.fullscreen.router.LauncherRouter
import com.diet.dietfyer.scenes.fullscreen.view.LauncherView
import com.diet.session.authentication.domain.interactor.SessionInteractor

class LauncherPresenterImpl(
    private val router: LauncherRouter,
    private val sessionInteractor: SessionInteractor
) : BasePresenterImpl<LauncherView>(), LauncherPresenter {
    override fun decideNavigation() {
        if (sessionInteractor.isUserLoggedIn()) {
            Handler().postDelayed({
                router.navigateToHome()
            }, 1000)
        } else {
            router.showLogin()
        }
    }
}