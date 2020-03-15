package com.diet.session.user

import android.content.Context
import android.content.SharedPreferences

class UserSharedPreferences(context: Context) : UserDataSource {

    companion object {
        const val USER_SHARED_PREFERENCES: String = "userPrefs"
        const val USER_LOGGED: String = "user_id"
    }

    private var mPrefs: SharedPreferences = context
        .getSharedPreferences(USER_SHARED_PREFERENCES, Context.MODE_PRIVATE)

    override fun isUserLogged(): Boolean {
        return mPrefs.getBoolean(USER_LOGGED, false)
    }

    override fun setUserLogged() {
        mPrefs.edit().putBoolean(USER_LOGGED, true).apply()
    }

    override fun logOutUser() {
        mPrefs.edit().putBoolean(USER_LOGGED, false).apply()
    }
}