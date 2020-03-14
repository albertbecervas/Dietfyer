package com.diet.session.user

import android.content.Context
import android.content.SharedPreferences

class UserSharedPreferences {

    companion object {
        const val USER: String = "user_id"
    }

    private lateinit var mPrefs: SharedPreferences

    fun init(context: Context) {
        mPrefs = context.getSharedPreferences("userPrefs", Context.MODE_PRIVATE)
    }

    fun isUserLogged(): Boolean {
        return mPrefs.getBoolean(USER, false)
    }

    fun setUserLogged() {
        mPrefs.edit().putBoolean(USER, true).apply()
    }
}