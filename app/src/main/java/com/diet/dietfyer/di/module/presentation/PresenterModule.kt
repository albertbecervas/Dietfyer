package com.diet.dietfyer.di.module.presentation

import com.diet.dietfyer.scenes.main.presenter.MainPresenter
import com.diet.dietfyer.scenes.main.presenter.MainPresenterImpl
import com.diet.dietfyer.scenes.main.router.MainRouter
import com.diet.session.LoginPresenter
import com.diet.session.LoginPresenterImpl
import dagger.Module
import dagger.Provides

@Module
open class PresenterModule {

    @Provides
    fun provideMainPresenter(router: MainRouter): MainPresenter {
        return MainPresenterImpl(router)
    }

    @Provides
    open fun provideLoginPresenter(): LoginPresenter {
        return LoginPresenterImpl()
    }
}