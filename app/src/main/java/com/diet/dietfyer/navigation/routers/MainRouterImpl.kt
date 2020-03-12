package com.diet.dietfyer.navigation.routers

import com.diet.dietfyer.navigation.navigator.Navigator
import com.diet.dietfyer.scenes.main.router.MainRouter
import com.diet.session.authentication.presentation.view.LoginFragment
import javax.inject.Inject

class MainRouterImpl @Inject constructor(
    private val navigator: Navigator
) : MainRouter {
    override fun loadDefaultFragment(layout: Int) {
    }
}