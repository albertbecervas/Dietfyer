package com.diet.dietfyer.di.module.presentation

import com.diet.dietfyer.navigation.navigator.Navigator
import com.diet.dietfyer.navigation.routers.LoginRouterImpl
import com.diet.dietfyer.navigation.routers.MainRouterImpl
import com.diet.dietfyer.scenes.main.router.MainRouter
import com.diet.session.authentication.presentation.router.LoginRouter
import dagger.Module
import dagger.Provides

@Module
open class RouterModule {

    @Provides
    open fun provideMainRouter(navigator: Navigator): MainRouter {
        return MainRouterImpl(navigator)
    }

    @Provides
    fun provideLoginRouter(navigator: Navigator): LoginRouter {
        return LoginRouterImpl(navigator)
    }
}