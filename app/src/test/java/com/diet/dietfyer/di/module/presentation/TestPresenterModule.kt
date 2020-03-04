package com.diet.dietfyer.di.module.presentation

import com.diet.session.LoginPresenter
import com.diet.session.LoginPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class TestPresenterModule {

    @Provides
    fun provideLoginPresenter(): LoginPresenter {
        return LoginPresenterImpl()
    }
}