package com.abecerra.core.di.component

import com.abecerra.core.di.module.NavigationModule
import com.abecerra.core.di.module.data.RepositoryModule
import com.abecerra.core.di.module.domain.InteractorModule
import com.abecerra.core.di.module.presentation.PresenterModule
import com.abecerra.core.di.module.presentation.RouterModule
import com.abecerra.core.di.module.presentation.ViewModule
import com.abecerra.core.scenes.main.presentation.view.MainActivity
import dagger.Component

@Component(
    modules = [ViewModule::class, PresenterModule::class, RouterModule::class,
        NavigationModule::class, InteractorModule::class, RepositoryModule::class]
)
interface ViewComponent {

    fun inject(mainActivity: MainActivity)
}