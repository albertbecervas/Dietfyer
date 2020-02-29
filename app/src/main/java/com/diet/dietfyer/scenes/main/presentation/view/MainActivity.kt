package com.diet.dietfyer.scenes.main.presentation.view

import android.os.Bundle
import com.diet.base.presentation.BaseActivity
import com.diet.dietfyer.R
import com.diet.dietfyer.di.component.DaggerActivityComponent
import com.diet.dietfyer.scenes.main.presentation.presenter.MainPresenter
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun getLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerActivityComponent.builder().build().inject(this)

        presenter.setView(this)
        presenter.loadDefaultFragment(supportFragmentManager)
    }
}
