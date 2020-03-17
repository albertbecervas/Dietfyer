package com.diet.dietfyer.di.module.data

import android.content.Context
import com.diet.session.user.data.UserDataSource
import com.diet.session.user.data.UserSharedPreferences
import dagger.Module
import dagger.Provides

@Module
class SharedPreferencesModule {

    @Provides
    fun provideUserSharedPreferences(context: Context): UserDataSource {
        return UserSharedPreferences(context)
    }
}