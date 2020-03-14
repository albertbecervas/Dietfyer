package com.diet.dietfyer.di.module.data

import android.content.Context
import com.diet.session.user.UserDataSource
import com.diet.session.user.UserSharedPreferences
import dagger.Module
import dagger.Provides

@Module
class SharedPreferencesModule {

    @Provides
    fun provideUserSharedPreferences(context: Context): UserDataSource {
        return UserSharedPreferences(context)
    }
}