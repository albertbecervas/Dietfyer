package com.diet.dietfyer.navigation.routers

import com.diet.dietfyer.R
import com.diet.dietfyer.navigation.navigator.Navigator
import com.diet.dietfyer.scenes.fullscreen.router.LauncherRouter
import com.diet.dietfyer.scenes.main.view.MainActivity
import com.diet.session.login.view.LoginFragment

class LauncherRouterImpl(
    private val navigator: Navigator,
    private val loginFragment: LoginFragment
) : LauncherRouter {

    override fun showLogin() {
        navigator.replaceFragment(loginFragment, R.id.fl)
    }

    override fun navigateToHome() {
        navigator.startActivityFinishingCurrent(MainActivity::class.java)
    }
}