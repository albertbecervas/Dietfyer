package com.diet.dietfyer.di.module.domain

import com.diet.diary.domain.interactor.DiaryInteractor
import com.diet.diary.domain.interactor.DiaryInteractorImpl
import com.diet.diary.domain.repository.DiaryRepository
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
    fun provideDiaryInteractor(
        DiaryRepository: DiaryRepository
    ): DiaryInteractor {
        return DiaryInteractorImpl(DiaryRepository)
    }
}