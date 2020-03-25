package com.diet.dietfyer.di.module.presentation

import com.diet.diary.domain.interactor.DiaryInteractor
import com.diet.diary.presentation.presenter.DiaryPresenter
import com.diet.diary.presentation.presenter.DiaryPresenterImpl
import com.diet.diary.presentation.router.DiaryRouter
import com.diet.dietfyer.scenes.launcher.presenter.LauncherPresenter
import com.diet.dietfyer.scenes.launcher.presenter.LauncherPresenterImpl
import com.diet.dietfyer.scenes.launcher.router.LauncherRouter
import com.diet.dietfyer.scenes.main.presenter.MainPresenter
import com.diet.dietfyer.scenes.main.presenter.MainPresenterImpl
import com.diet.dietfyer.scenes.main.router.MainRouter
import com.diet.session.authentication.domain.interactor.SessionInteractor
import com.diet.session.login.presenter.LoginPresenter
import com.diet.session.login.presenter.LoginPresenterImpl
import com.diet.session.login.router.LoginRouter
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

    @Provides
    open fun provideDiaryPresenter(
        router: DiaryRouter, interactor: DiaryInteractor
    ): DiaryPresenter {
        return DiaryPresenterImpl(router, interactor)
    }
}