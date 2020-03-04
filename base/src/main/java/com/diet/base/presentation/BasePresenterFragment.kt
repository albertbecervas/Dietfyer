package com.diet.base.presentation

import com.diet.base.PresenterConfigurator

abstract class BasePresenterFragment<PRESENTER>(
    private val presenterConfigurator: PresenterConfigurator<PRESENTER>
) : BaseFragment() {

    fun getPresenter(): PRESENTER? {
        return presenterConfigurator.getPresenter()
    }
}