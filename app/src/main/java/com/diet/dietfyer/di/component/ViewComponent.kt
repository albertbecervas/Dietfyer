package com.diet.dietfyer.di.component

import com.diet.dietfyer.di.module.data.GoogleAuthModule
import com.diet.dietfyer.di.module.data.NetworkModule
import com.diet.dietfyer.di.module.data.RepositoryModule
import com.diet.dietfyer.di.module.data.SharedPreferencesModule
import com.diet.dietfyer.di.module.domain.InteractorModule
import com.diet.dietfyer.di.module.presentation.NavigationModule
import com.diet.dietfyer.di.module.presentation.PresenterModule
import com.diet.dietfyer.di.module.presentation.RouterModule
import com.diet.dietfyer.di.module.presentation.ViewModule
import com.diet.dietfyer.scenes.launcher.view.LauncherActivity
import com.diet.dietfyer.scenes.main.view.MainActivity
import dagger.Component

@Component(
    modules = [ViewModule::class, PresenterModule::class, RouterModule::class,
        NavigationModule::class, InteractorModule::class, RepositoryModule::class,
        NetworkModule::class, SharedPreferencesModule::class, GoogleAuthModule::class]
)
interface ViewComponent {

    fun inject(launcherActivity: LauncherActivity)
    fun inject(mainActivity: MainActivity)
}