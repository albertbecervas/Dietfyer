package com.diet.dietfyer.di.module.data

import com.diet.diary.data.DiaryRepositoryImpl
import com.diet.diary.domain.repository.DiaryRepository
import com.diet.network.authentication.AuthService
import com.diet.network.diary.DiaryService
import com.diet.session.authentication.data.SessionRepositoryImpl
import com.diet.session.authentication.domain.repository.SessionRepository
import com.diet.session.user.data.UserDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideSessionRepository(
        authService: AuthService, userDataSource: UserDataSource
    ): SessionRepository {
        return SessionRepositoryImpl(authService, userDataSource)
    }

    @Provides
    fun provideDiaryRepository(
        DiaryService: DiaryService, userDataSource: UserDataSource
    ): DiaryRepository {
        return DiaryRepositoryImpl(userDataSource, DiaryService)
    }
}