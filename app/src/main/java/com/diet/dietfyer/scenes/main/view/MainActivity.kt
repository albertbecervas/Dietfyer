package com.diet.dietfyer.scenes.main.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.abecerra.base.presentation.BaseActivity
import com.abecerra.components.bottomnavigation.BottomNavigationListener
import com.diet.dietfyer.R
import com.diet.dietfyer.di.component.DaggerViewComponent
import com.diet.dietfyer.di.module.presentation.ViewModule
import com.diet.dietfyer.scenes.launcher.view.LauncherActivity
import com.diet.dietfyer.scenes.main.presenter.MainPresenter
import com.diet.session.authentication.domain.interactor.SessionInteractor
import com.google.android.material.appbar.AppBarLayout
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
        initToolBar()

    }

    private fun initToolBar() {
        setSupportActionBar(findViewById(R.id.main_collapsible_toolbar))
        disableToolbarScroll()
    }

    private fun disableToolbarScroll() {
        val mainAppBarLayout = findViewById<AppBarLayout>(R.id.main_appbar_layout)
        val params = mainAppBarLayout.layoutParams as CoordinatorLayout.LayoutParams
        if (params.behavior == null)
            params.behavior = AppBarLayout.Behavior()
        val behaviour = params.behavior as AppBarLayout.Behavior
        behaviour.setDragCallback(object : AppBarLayout.Behavior.DragCallback() {
            override fun canDrag(appBarLayout: AppBarLayout): Boolean {
                return false
            }
        })
    }

    private fun initBottomNavigation() {
        bottom_navigation.setItems(presenter.getNavigationItems())
        bottom_navigation.setBottomNavigationListener(object : BottomNavigationListener {
            override fun onItemSelected(position: Int) {
                Toast.makeText(this@MainActivity, "$position", Toast.LENGTH_SHORT).show()
                when (position) {
                    DIARY_POSITION -> {
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
        const val DIARY_POSITION = 1
    }
}
