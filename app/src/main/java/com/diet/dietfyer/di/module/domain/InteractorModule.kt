package com.diet.dietfyer.di.module.domain

import com.diet.dairy.domain.interactor.DairyInteractor
import com.diet.dairy.domain.interactor.DairyInteractorImpl
import com.diet.dairy.domain.repository.DairyRepository
import com.diet.session.authentication.domain.interactor.SessionInteractor
import com.diet.session.authentication.domain.interactor.SessionInteractorImpl
import com.diet.session.authentication.domain.repository.SessionRepository
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun provideSessionInteractor(
        sessionRepository: SessionRepository,
        googleSignInClient: GoogleSignInClient
    ): SessionInteractor {
        return SessionInteractorImpl(sessionRepository, googleSignInClient)
    }

    @Provides
    fun provideDairyInteractor(
        dairyRepository: DairyRepository
    ): DairyInteractor {
        return DairyInteractorImpl(dairyRepository)
    }
}