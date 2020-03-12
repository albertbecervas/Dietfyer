package com.diet.dietfyer.di.module.data

import com.diet.network.UserService
import com.diet.network.UserServiceImpl
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideUserService(): UserService {
        return UserServiceImpl()
    }
}