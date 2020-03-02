package com.diet.dietfyer.di.module.domain

import com.diet.dietfyer.scenes.domain.MainInteractor
import com.diet.dietfyer.scenes.domain.MainInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun provideMainInteractor(): MainInteractor {
        return MainInteractorImpl()
    }
}