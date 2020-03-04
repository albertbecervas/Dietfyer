package com.diet.base

interface PresenterConfigurator<PRESENTER> {

    fun getPresenter(): PRESENTER?
}