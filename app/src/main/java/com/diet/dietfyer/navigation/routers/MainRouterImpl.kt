package com.diet.dietfyer.navigation.routers

import com.diet.dairy.presentation.view.DairyFragment
import com.diet.dietfyer.navigation.navigator.Navigator
import com.diet.dietfyer.scenes.main.router.MainRouter
import javax.inject.Inject

class MainRouterImpl @Inject constructor(
    private val navigator: Navigator,
    private val dairyFragment: DairyFragment
) : MainRouter {
    override fun loadDefaultFragment(layout: Int) {
    }

    override fun loadDairyFragment(layout: Int) {
        navigator.replaceFragment(dairyFragment, layout)
    }
}