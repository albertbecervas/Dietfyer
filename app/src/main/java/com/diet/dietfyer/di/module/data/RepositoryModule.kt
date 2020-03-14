package com.diet.dietfyer.di.module.data

import com.diet.network.UserService
import com.diet.session.authentication.data.SessionRepositoryImpl
import com.diet.session.authentication.domain.repository.SessionRepository
import com.diet.session.user.UserDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideSessionRepository(
        userService: UserService, userDataSource: UserDataSource
    ): SessionRepository {
        return SessionRepositoryImpl(userService, userDataSource)
    }
}