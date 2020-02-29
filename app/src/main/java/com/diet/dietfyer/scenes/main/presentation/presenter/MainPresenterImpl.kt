package com.diet.dietfyer.scenes.main.presentation.presenter

import androidx.fragment.app.FragmentManager
import com.diet.base.presentation.BasePresenterImpl
import com.diet.dietfyer.R
import com.diet.dietfyer.scenes.main.domain.MainInteractor
import com.diet.dietfyer.scenes.main.domain.MainInteractorOutput
import com.diet.dietfyer.scenes.main.presentation.router.MainRouter
import com.diet.dietfyer.scenes.main.presentation.view.MainView

class MainPresenterImpl(private val router: MainRouter, private val interactor: MainInteractor) :
    BasePresenterImpl<MainView>(), MainPresenter, MainInteractorOutput {

    init {
        interactor.setInteractorOutput(this)
    }

    override fun loadDefaultFragment(supportFragmentManager: FragmentManager) {
        router.loadDefaultFragment(supportFragmentManager, R.id.base_fl)
    }
}