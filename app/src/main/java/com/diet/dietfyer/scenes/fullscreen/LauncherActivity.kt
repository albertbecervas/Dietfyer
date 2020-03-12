package com.diet.dietfyer.scenes.fullscreen

import android.os.Bundle
import android.os.Handler
import com.abecerra.base.presentation.BaseActivity
import com.diet.dietfyer.R
import com.diet.dietfyer.di.component.DaggerViewComponent
import com.diet.dietfyer.di.module.presentation.ViewModule
import com.diet.session.authentication.presentation.view.LoginFragment
import javax.inject.Inject

class LauncherActivity : BaseActivity() {

    @Inject
    lateinit var loginFragment: LoginFragment

    override fun getLayout(): Int = R.layout.activity_full_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerViewComponent.builder().viewModule(ViewModule(this))
            .build().inject(this)

        Handler().postDelayed({
            supportFragmentManager.beginTransaction().add(R.id.fl, loginFragment).commit()
        }, 1000)
    }
}
