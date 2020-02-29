package com.diet.dietfyer.navigation

import androidx.fragment.app.FragmentManager
import com.diet.base.presentation.BaseRouterImpl
import com.diet.dietfyer.scenes.main.presentation.router.MainRouter
import com.diet.dietfyer.scenes.main.presentation.view.MainView
import com.diet.session.LoginFragment
import java.lang.ref.WeakReference
import javax.inject.Inject

class MainRouterImpl @Inject constructor(private val loginFragment: LoginFragment)
    : BaseRouterImpl<MainView>(), MainRouter {

    override fun setView(view: MainView) {
        viewReference = WeakReference(view)
    }

    override fun loadDefaultFragment(supportFragmentManager: FragmentManager, layout: Int) {
        supportFragmentManager.beginTransaction().add(layout, loginFragment).commit()
    }
}