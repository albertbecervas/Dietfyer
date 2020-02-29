package com.diet.dietfyer.di.module.presentation

import com.diet.base.PresenterConfigurator
import com.diet.session.LoginFragment
import com.diet.session.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {

    @Provides
    fun provideLoginFragment(loginPresenter: LoginPresenter): LoginFragment {
        return LoginFragment(object : PresenterConfigurator<LoginPresenter> {
            override fun getPresenter(): LoginPresenter? = loginPresenter
        })
    }
}