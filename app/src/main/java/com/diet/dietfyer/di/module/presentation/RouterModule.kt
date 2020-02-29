package com.diet.dietfyer.di.module.presentation

import com.diet.dietfyer.navigation.MainRouterImpl
import com.diet.dietfyer.scenes.main.presentation.router.MainRouter
import com.diet.session.LoginFragment
import dagger.Module
import dagger.Provides

@Module
class RouterModule {

    @Provides
    fun provideMainRouter(loginFragment: LoginFragment): MainRouter {
        return MainRouterImpl(loginFragment)
    }
}