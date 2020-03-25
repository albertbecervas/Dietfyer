package com.diet.dietfyer.di.module.data

import com.diet.network.authentication.AuthService
import com.diet.network.authentication.AuthServiceImpl
import com.diet.network.dairy.DairyService
import com.diet.network.dairy.DairyServiceImpl
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideUserService(): AuthService {
        return AuthServiceImpl()
    }

    @Provides
    fun provideDairyService(): DairyService {
        return DairyServiceImpl()
    }
}