package com.diet.session.user.data

import android.content.Context
import android.content.SharedPreferences
import com.abecerra.base.utils.StringUtils

class UserSharedPreferences(context: Context) :
    UserDataSource {

    companion object {
        const val USER_SHARED_PREFERENCES: String = "userPrefs"
        const val USER_LOGGED: String = "user_logged"
        const val USER_LOGGED_ID : String = "user_id"
    }

    private var mPrefs: SharedPreferences = context
        .getSharedPreferences(USER_SHARED_PREFERENCES, Context.MODE_PRIVATE)

    override fun isUserLogged(): Boolean {
        return mPrefs.getBoolean(USER_LOGGED, false)
    }

    override fun setUserLogged() {
        mPrefs.edit().putBoolean(USER_LOGGED, true).apply()
    }

    override fun setUserId(userId: String) {
        mPrefs.edit().putString(USER_LOGGED_ID, userId).apply()
    }

    override fun logOutUser() {
        mPrefs.edit().putBoolean(USER_LOGGED, false).apply()
        mPrefs.edit().putString(USER_LOGGED_ID, StringUtils.EMPTY_STRING).apply()
    }

    override fun getCurrentUserId(): String {
        return mPrefs.getString(USER_LOGGED_ID, StringUtils.EMPTY_STRING) ?: StringUtils.EMPTY_STRING
    }
}