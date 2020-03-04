package com.abecerra.core.scenes.main.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.abecerra.core.R
import com.abecerra.core.scenes.main.domain.MainInteractor
import com.abecerra.core.scenes.main.domain.MainInteractorOutput
import com.abecerra.core.scenes.main.presentation.router.MainRouter
import com.abecerra.core.scenes.main.presentation.view.MainView

class MainPresenterImpl(private val router: MainRouter, private val interactor: MainInteractor) :
    BasePresenterImpl<MainView>(), MainPresenter, MainInteractorOutput {

    init {
        interactor.setInteractorOutput(this)
    }

    override fun loadDefaultFragment() {
        router.loadDefaultFragment(R.id.base_fl)
    }
}