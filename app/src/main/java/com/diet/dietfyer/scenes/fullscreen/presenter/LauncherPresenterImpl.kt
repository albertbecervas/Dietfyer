package com.diet.dietfyer.scenes.fullscreen.presenter

import android.os.Handler
import com.abecerra.base.presentation.BasePresenterImpl
import com.diet.dietfyer.scenes.fullscreen.router.LauncherRouter
import com.diet.dietfyer.scenes.fullscreen.view.LauncherView
import com.diet.session.user.UserDataSource

class LauncherPresenterImpl(
    private val router: LauncherRouter,
    private val userDataSource: UserDataSource
) : BasePresenterImpl<LauncherView>(), LauncherPresenter {
    override fun decideNavigation() {
        Handler().postDelayed({
            if (userDataSource.isUserLogged()) {
                router.navigateToHome()
            } else {
                router.showLogin()
            }
        }, 2000)
    }
}