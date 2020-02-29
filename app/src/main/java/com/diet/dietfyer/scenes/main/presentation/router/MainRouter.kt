package com.diet.dietfyer.scenes.main.presentation.router

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import com.diet.dietfyer.scenes.main.presentation.view.MainView

interface MainRouter {

    fun setView(view: MainView)

    fun loadDefaultFragment(supportFragmentManager: FragmentManager, @IdRes layout: Int)

}