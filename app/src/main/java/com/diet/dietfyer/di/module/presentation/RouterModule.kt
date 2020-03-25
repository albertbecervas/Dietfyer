package com.diet.dietfyer.di.module.presentation

import com.diet.dairy.presentation.router.DairyRouter
import com.diet.dairy.presentation.view.DairyFragment
import com.diet.dietfyer.navigation.navigator.Navigator
import com.diet.dietfyer.navigation.routers.DairyRouterImpl
import com.diet.dietfyer.navigation.routers.LauncherRouterImpl
import com.diet.dietfyer.navigation.routers.LoginRouterImpl
import com.diet.dietfyer.navigation.routers.MainRouterImpl
import com.diet.dietfyer.scenes.launcher.router.LauncherRouter
import com.diet.dietfyer.scenes.main.router.MainRouter
import com.diet.session.login.router.LoginRouter
import com.diet.session.login.view.LoginFragment
import dagger.Module
import dagger.Provides

@Module
class RouterModule {

    @Provides
    fun provideLauncherRouter(navigator: Navigator, loginFragment: LoginFragment): LauncherRouter {
        return LauncherRouterImpl(navigator, loginFragment)
    }

    @Provides
    fun provideMainRouter(navigator: Navigator, dairyFragment: DairyFragment): MainRouter {
        return MainRouterImpl(navigator, dairyFragment)
    }

    @Provides
    fun provideLoginRouter(navigator: Navigator): LoginRouter {
        return LoginRouterImpl(navigator)
    }

    @Provides
    fun provideDairyRouter(navigator: Navigator): DairyRouter {
        return DairyRouterImpl()
    }
}