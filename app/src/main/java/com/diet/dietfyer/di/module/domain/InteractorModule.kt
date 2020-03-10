package com.diet.dietfyer.di.module.domain

import com.diet.session.authentication.domain.interactor.LoginInteractor
import com.diet.session.authentication.domain.interactor.LoginInteractorImpl
import com.diet.session.authentication.domain.repository.SessionRepository
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun provideLoginInteractor(sessionRepository: SessionRepository): LoginInteractor {
        return LoginInteractorImpl(sessionRepository)
    }
}