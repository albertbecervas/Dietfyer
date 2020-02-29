package com.abecerra.core.scenes.main.presentation.view

import android.os.Bundle
import com.abecerra.base.presentation.BaseActivity
import com.abecerra.core.R
import com.abecerra.core.di.component.DaggerViewComponent
import com.abecerra.core.di.module.presentation.ViewModule
import com.abecerra.core.scenes.main.presentation.presenter.MainPresenter
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun getLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerViewComponent.builder()
            .viewModule(ViewModule(this)).build().inject(this)

        presenter.setView(this)
        presenter.loadDefaultFragment()
    }
}
