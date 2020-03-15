package com.diet.dietfyer.scenes.fullscreen.view

import android.os.Bundle
import com.abecerra.base.presentation.BaseActivity
import com.diet.dietfyer.R
import com.diet.dietfyer.di.component.DaggerViewComponent
import com.diet.dietfyer.di.module.presentation.ViewModule
import com.diet.dietfyer.scenes.fullscreen.presenter.LauncherPresenter
import javax.inject.Inject

class LauncherActivity : BaseActivity(), LauncherView {

    @Inject
    lateinit var presenter: LauncherPresenter

    override fun getLayout(): Int = R.layout.activity_launcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerViewComponent.builder().viewModule(ViewModule(this))
            .build().inject(this)
        presenter.setView(this)
        presenter.decideNavigation()
    }
}
