package com.abecerra.core.di.module.presentation

import com.abecerra.core.navigation.navigator.Navigator
import com.abecerra.core.navigation.routers.MainRouterImpl
import com.abecerra.core.scenes.main.presentation.router.MainRouter
import com.diet.session.LoginFragment
import dagger.Module
import dagger.Provides

@Module
class RouterModule {

    @Provides
    fun provideMainRouter(loginFragment: LoginFragment, navigator: Navigator): MainRouter {
        return MainRouterImpl(loginFragment, navigator)
    }
}