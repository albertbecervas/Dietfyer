package com.diet.dietfyer.scenes.main.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.abecerra.base.presentation.BaseActivity
import com.abecerra.components.bottomnavigation.BottomNavigationListener
import com.diet.dietfyer.R
import com.diet.dietfyer.di.component.DaggerViewComponent
import com.diet.dietfyer.di.module.presentation.ViewModule
import com.diet.dietfyer.scenes.launcher.view.LauncherActivity
import com.diet.dietfyer.scenes.main.presenter.MainPresenter
import com.diet.session.authentication.domain.interactor.SessionInteractor
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var sessionInteractor: SessionInteractor

    override fun getLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerViewComponent.builder().viewModule(ViewModule(this))
            .build().inject(this)

        presenter.setView(this)
        presenter.loadHomeFragment()

        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        bottom_navigation.setItems(presenter.getNavigationItems())
        bottom_navigation.setBottomNavigationListener(object : BottomNavigationListener {
            override fun onItemSelected(position: Int) {
                Toast.makeText(this@MainActivity, "$position", Toast.LENGTH_SHORT).show()
                when (position) {
                    diary_POSITION -> {
                        presenter.loadDiaryFragment()
                    }
                    4 -> {
                        sessionInteractor.logout()
                        startActivity(Intent(this@MainActivity, LauncherActivity::class.java))
                        finish()
                    }
                }
            }
        })
    }

    companion object {
        const val diary_POSITION = 1
    }
}
