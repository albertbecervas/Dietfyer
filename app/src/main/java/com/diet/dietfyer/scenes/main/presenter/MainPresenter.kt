package com.diet.dietfyer.scenes.main.presenter

import com.abecerra.base.presentation.BasePresenter
import com.abecerra.components.bottomnavigation.viewModel.NavigationItem
import com.diet.dietfyer.scenes.main.view.MainView

interface MainPresenter : BasePresenter<MainView> {

    fun loadHomeFragment()

    fun loadDairyFragment()

    fun getNavigationItems(): List<NavigationItem>
}