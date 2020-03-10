package com.abecerra.base.presentation

abstract class BasePresenterFragment<PRESENTER : BasePresenter<*>> : BaseFragment() {

    protected var presenter: PRESENTER? = null

    fun injectPresenter(presenter: PRESENTER) {
        this.presenter = presenter
    }
}