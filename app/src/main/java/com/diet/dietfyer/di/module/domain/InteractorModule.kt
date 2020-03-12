package com.diet.dietfyer.di.module.domain

import com.diet.session.authentication.domain.interactor.SessionInteractor
import com.diet.session.authentication.domain.interactor.SessionInteractorImpl
import com.diet.session.authentication.domain.repository.SessionRepository
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun provideSessionInteractor(sessionRepository: SessionRepository): SessionInteractor {
        return SessionInteractorImpl(sessionRepository)
    }
}