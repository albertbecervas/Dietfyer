package com.abecerra.core.di.module.domain

import com.abecerra.core.scenes.main.domain.MainInteractor
import com.abecerra.core.scenes.main.domain.MainInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun provideMainInteractor(): MainInteractor {
        return MainInteractorImpl()
    }
}