package com.abecerra.core.scenes.main.presentation.view

import android.os.Bundle
import com.abecerra.base.presentation.BasePresenterActivity
import com.abecerra.core.R
import com.abecerra.core.scenes.main.presentation.presenter.MainPresenter

class MainActivity : BasePresenterActivity<MainPresenter>(), MainView {

    override fun getLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter?.setView(this)
        presenter?.loadDefaultFragment()
    }
}
