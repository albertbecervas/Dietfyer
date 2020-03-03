package com.diet.dietfyer.scenes.main.view

import android.os.Bundle
import android.widget.Toast
import com.abecerra.base.presentation.BaseActivity
import com.abecerra.components.bottomnavigation.BottomNavigationListener
import com.diet.dietfyer.R
import com.diet.dietfyer.di.component.DaggerViewComponent
import com.diet.dietfyer.di.module.presentation.ViewModule
import com.diet.dietfyer.scenes.main.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

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
                Toast.makeText(this@MainActivity, position, Toast.LENGTH_SHORT).show()
            }
        })
    }

}
