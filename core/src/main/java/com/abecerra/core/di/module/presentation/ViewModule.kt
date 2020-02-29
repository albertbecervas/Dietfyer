package com.abecerra.core.di.module.presentation

import android.content.Context
import com.abecerra.base.PresenterConfigurator
import com.diet.session.LoginFragment
import com.diet.session.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class ViewModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideLoginFragment(loginPresenter: LoginPresenter): LoginFragment {
        return LoginFragment(object : PresenterConfigurator<LoginPresenter> {
            override fun getPresenter(): LoginPresenter? = loginPresenter
        })
    }
}