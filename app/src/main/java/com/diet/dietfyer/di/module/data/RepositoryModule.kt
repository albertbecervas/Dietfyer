package com.diet.dietfyer.di.module.data

import com.diet.network.UserService
import com.diet.session.authentication.data.SessionRepositoryImpl
import com.diet.session.authentication.domain.repository.SessionRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideSessionRepository(userService: UserService): SessionRepository {
        return SessionRepositoryImpl(userService)
    }
}