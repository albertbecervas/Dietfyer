package com.diet.dietfyer.navigation.routers

import com.diet.diary.presentation.view.DiaryFragment
import com.diet.dietfyer.navigation.navigator.Navigator
import com.diet.dietfyer.scenes.main.router.MainRouter
import javax.inject.Inject

class MainRouterImpl @Inject constructor(
    private val navigator: Navigator,
    private val DiaryFragment: DiaryFragment
) : MainRouter {
    override fun loadDefaultFragment(layout: Int) {
    }

    override fun loaddiaryFragment(layout: Int) {
        navigator.replaceFragment(DiaryFragment, layout)
    }
}