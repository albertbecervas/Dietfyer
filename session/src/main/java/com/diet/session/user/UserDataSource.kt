package com.diet.session.user

interface UserDataSource {

    fun isUserLogged(): Boolean

    fun setUserLogged()
}