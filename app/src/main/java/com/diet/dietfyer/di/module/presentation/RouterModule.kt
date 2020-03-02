package com.diet.dietfyer.di.module.presentation

import com.diet.dietfyer.navigation.navigator.Navigator
import com.diet.dietfyer.navigation.routers.MainRouterImpl
import com.diet.dietfyer.scenes.presentation.router.MainRouter
import com.diet.session.LoginFragment
import dagger.Module
import dagger.Provides

@Module
class RouterModule {

    @Provides
    fun provideMainRouter(loginFragment: LoginFragment, navigator: Navigator): MainRouter {
        return MainRouterImpl(
            loginFragment,
            navigator
        )
    }
}