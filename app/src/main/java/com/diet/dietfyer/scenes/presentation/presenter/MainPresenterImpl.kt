package com.diet.dietfyer.scenes.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.diet.dietfyer.R
import com.diet.dietfyer.scenes.domain.MainInteractor
import com.diet.dietfyer.scenes.domain.MainInteractorOutput
import com.diet.dietfyer.scenes.presentation.router.MainRouter
import com.diet.dietfyer.scenes.presentation.view.MainView

class MainPresenterImpl(private val router: MainRouter, private val interactor: MainInteractor) :
    BasePresenterImpl<MainView>(),
    MainPresenter,
    MainInteractorOutput {

    init {
        interactor.setInteractorOutput(this)
    }

    override fun loadDefaultFragment() {
        router.loadDefaultFragment(R.id.base_fl)
    }
}