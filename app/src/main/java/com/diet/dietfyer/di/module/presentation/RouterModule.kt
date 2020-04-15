package com.diet.dietfyer.di.module.presentation

import com.diet.diary.presentation.router.DiaryRouter
import com.diet.diary.presentation.view.DiaryFragment
import com.diet.dietfyer.navigation.navigator.Navigator
import com.diet.dietfyer.navigation.routers.DiaryRouterImpl
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
    fun provideMainRouter(navigator: Navigator, DiaryFragment: DiaryFragment): MainRouter {
        return MainRouterImpl(navigator, DiaryFragment)
    }

    @Provides
    fun provideLoginRouter(navigator: Navigator): LoginRouter {
        return LoginRouterImpl(navigator)
    }

    @Provides
    fun provideDiaryRouter(navigator: Navigator): DiaryRouter {
        return DiaryRouterImpl()
    }
}