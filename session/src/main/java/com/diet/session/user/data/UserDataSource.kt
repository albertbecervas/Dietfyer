package com.diet.session.user.data

interface UserDataSource {

    fun isUserLogged(): Boolean

    fun setUserLogged()

    fun logOutUser()
}