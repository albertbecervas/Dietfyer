package com.diet.dietfyer.di.module.presentation

import android.content.Context
import com.diet.session.login.view.LoginFragment
import com.diet.session.login.presenter.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
open class ViewModule(private val context: Context) {

    @Provides
    open fun provideContext(): Context = context

    @Provides
    open fun provideLoginFragment(loginPresenter: LoginPresenter): LoginFragment {
        val loginFragment = LoginFragment()
        loginFragment.injectPresenter(loginPresenter)
        return loginFragment
    }
}