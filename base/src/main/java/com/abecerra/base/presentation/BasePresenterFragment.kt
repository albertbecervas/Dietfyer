package com.abecerra.base.presentation

import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.abecerra.base.R


abstract class BasePresenterFragment<PRESENTER : BasePresenter<*>>(var layout: Int) :
    BaseFragment(layout), BaseView {

    protected var presenter: PRESENTER? = null

    fun injectPresenter(presenter: PRESENTER) {
        this.presenter = presenter
    }

    override fun showErrorMessage(error: String) {
        Toast.makeText(this.context, error, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {
        view?.findViewById<ProgressBar>(R.id.loading_progress_bar)?.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        view?.findViewById<ProgressBar>(R.id.loading_progress_bar)?.visibility = View.GONE
    }
}