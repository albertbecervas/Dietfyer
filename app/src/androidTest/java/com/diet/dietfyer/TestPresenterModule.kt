package com.diet.dietfyer

import com.diet.dietfyer.di.module.presentation.PresenterModule
import com.diet.session.LoginPresenter
import com.diet.session.LoginPresenterImpl


class TestPresenterModule : PresenterModule() {

    override fun provideLoginPresenter(): LoginPresenter {
        return LoginPresenterImpl()
    }
}