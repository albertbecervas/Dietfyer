package com.diet.dietfyer.navigation.routers

import com.diet.dietfyer.navigation.navigator.Navigator
import com.diet.dietfyer.scenes.main.router.MainRouter
import com.diet.session.LoginFragment
import javax.inject.Inject

class MainRouterImpl @Inject constructor(
    private val loginFragment: LoginFragment, private val navigator: Navigator
) : MainRouter {
    override fun loadDefaultFragment(layout: Int) {
        navigator.replaceFragment(loginFragment, layout)
    }
}