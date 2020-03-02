package com.diet.dietfyer.di.module.presentation

import com.diet.dietfyer.scenes.domain.MainInteractor
import com.diet.dietfyer.scenes.presentation.presenter.MainPresenter
import com.diet.dietfyer.scenes.presentation.presenter.MainPresenterImpl
import com.diet.dietfyer.scenes.presentation.router.MainRouter
import com.diet.session.LoginPresenter
import com.diet.session.LoginPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideMainPresenter(router: MainRouter, interactor: MainInteractor): MainPresenter {
        return MainPresenterImpl(
            router,
            interactor
        )
    }


    @Provides
    fun provideLoginPresenter(): LoginPresenter {
        return LoginPresenterImpl()
    }
}