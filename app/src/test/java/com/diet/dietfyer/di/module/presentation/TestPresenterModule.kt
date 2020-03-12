package com.diet.dietfyer.di.module.presentation

import com.diet.session.authentication.presentation.presenter.LoginPresenter
import com.diet.session.authentication.presentation.presenter.LoginPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class TestPresenterModule {

    @Provides
    fun provideLoginPresenter(): LoginPresenter {
        return LoginPresenterImpl()
    }
}