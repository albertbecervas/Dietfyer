package com.diet.session.user

object UserSession {

    private var userDataSource: UserSharedPreferences? = null

    fun injectUserDataSource(userDataSource: UserSharedPreferences) {
        this.userDataSource = userDataSource
    }

    fun isUserLogged(): Boolean {
        return userDataSource?.isUserLogged() ?: false
    }
}