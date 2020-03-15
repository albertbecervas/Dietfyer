package com.diet.dietfyer.di.module.presentation

import com.diet.dietfyer.scenes.fullscreen.presenter.LauncherPresenter
import com.diet.dietfyer.scenes.fullscreen.presenter.LauncherPresenterImpl
import com.diet.dietfyer.scenes.fullscreen.router.LauncherRouter
import com.diet.dietfyer.scenes.main.presenter.MainPresenter
import com.diet.dietfyer.scenes.main.presenter.MainPresenterImpl
import com.diet.dietfyer.scenes.main.router.MainRouter
import com.diet.session.authentication.domain.interactor.SessionInteractor
import com.diet.session.authentication.presentation.presenter.LoginPresenter
import com.diet.session.authentication.presentation.presenter.LoginPresenterImpl
import com.diet.session.authentication.presentation.router.LoginRouter
import dagger.Module
import dagger.Provides

@Module
open class PresenterModule {

    @Provides
    fun provideLauncherPresenter(
        router: LauncherRouter,
        sessionInteractor: SessionInteractor
    ): LauncherPresenter {
        return LauncherPresenterImpl(router, sessionInteractor)
    }

    @Provides
    fun provideMainPresenter(router: MainRouter): MainPresenter {
        return MainPresenterImpl(router)
    }

    @Provides
    open fun provideLoginPresenter(
        router: LoginRouter, interactor: SessionInteractor
    ): LoginPresenter {
        return LoginPresenterImpl(router, interactor)
    }
}