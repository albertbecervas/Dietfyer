package com.diet.dietfyer.di.module.data

import com.diet.dairy.data.DairyRepositoryImpl
import com.diet.dairy.domain.repository.DairyRepository
import com.diet.network.authentication.AuthService
import com.diet.network.dairy.DairyService
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
    fun provideDairyRepository(
        dairyService: DairyService, userDataSource: UserDataSource
    ): DairyRepository {
        return DairyRepositoryImpl(userDataSource, dairyService)
    }
}