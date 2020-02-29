package com.diet.dietfyer.di.component

import com.diet.dietfyer.di.module.data.RepositoryModule
import com.diet.dietfyer.di.module.presentation.FragmentModule
import com.diet.dietfyer.di.module.domain.InteractorModule
import com.diet.dietfyer.di.module.presentation.PresenterModule
import com.diet.dietfyer.di.module.presentation.RouterModule
import com.diet.session.LoginFragment
import dagger.Component

@Component(
    modules = [FragmentModule::class, PresenterModule::class, RouterModule::class,
        InteractorModule::class, RepositoryModule::class]
)
interface FragmentComponent {

    fun inject(loginFragment: LoginFragment)
}