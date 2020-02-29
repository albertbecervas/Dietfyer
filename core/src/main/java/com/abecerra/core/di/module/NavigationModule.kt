package com.abecerra.core.di.module

import android.content.Context
import com.abecerra.core.navigation.navigator.Navigator
import dagger.Module
import dagger.Provides
import java.lang.ref.WeakReference

@Module
class NavigationModule {

    @Provides
    fun provideNavigator(context: Context): Navigator {
        return Navigator(WeakReference(context))
    }
}