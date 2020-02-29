package com.diet.dietfyer.di.component

import com.diet.dietfyer.di.module.data.RepositoryModule
import com.diet.dietfyer.di.module.domain.InteractorModule
import com.diet.dietfyer.di.module.presentation.PresenterModule
import com.diet.dietfyer.di.module.presentation.RouterModule
import com.diet.dietfyer.di.module.presentation.ActivityModule
import com.diet.dietfyer.di.module.presentation.FragmentModule
import com.diet.dietfyer.scenes.main.presentation.view.MainActivity
import dagger.Component

@Component(
    modules = [ActivityModule::class, FragmentModule::class, PresenterModule::class,
        RouterModule::class, InteractorModule::class, RepositoryModule::class]
)
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}