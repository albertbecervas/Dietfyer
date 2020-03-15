package com.diet.dietfyer.di.module.data

import com.diet.network.authentication.AuthService
import com.diet.network.authentication.AuthServiceImpl
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideUserService(): AuthService {
        return AuthServiceImpl()
    }
}