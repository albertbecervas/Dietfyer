package com.diet.dietfyer.di.module.data

import com.diet.network.authentication.AuthService
import com.diet.session.authentication.data.SessionRepositoryImpl
import com.diet.session.authentication.domain.repository.SessionRepository
import com.diet.session.user.UserDataSource
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
}