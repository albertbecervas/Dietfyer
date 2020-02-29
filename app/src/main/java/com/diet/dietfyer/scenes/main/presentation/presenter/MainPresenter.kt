package com.diet.dietfyer.scenes.main.presentation.presenter

import androidx.fragment.app.FragmentManager
import com.diet.base.presentation.BasePresenter
import com.diet.dietfyer.scenes.main.presentation.view.MainView

interface MainPresenter : BasePresenter<MainView> {

    fun loadDefaultFragment(supportFragmentManager: FragmentManager)
}