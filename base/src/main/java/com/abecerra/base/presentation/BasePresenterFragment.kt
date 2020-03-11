package com.abecerra.base.presentation

import android.widget.Toast

abstract class BasePresenterFragment<PRESENTER : BasePresenter<*>>(layout: Int) :
    BaseFragment(layout), BaseView {

    protected var presenter: PRESENTER? = null

    fun injectPresenter(presenter: PRESENTER) {
        this.presenter = presenter
    }

    override fun showErrorMessage(error: String) {
        Toast.makeText(this.context, error, Toast.LENGTH_SHORT).show()
    }
}