package com.diet.dietfyer.di.module.presentation

import android.content.Context
import com.abecerra.base.PresenterConfigurator
import com.diet.session.LoginFragment
import com.diet.session.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
open class ViewModule(private val context: Context?) {

    @Provides
    open fun provideContext(): Context? = context

    @Provides
    open fun provideLoginFragment(loginPresenter: LoginPresenter): LoginFragment {
        return LoginFragment(object : PresenterConfigurator<LoginPresenter> {
            override fun getPresenter(): LoginPresenter? = loginPresenter
        })
    }
}