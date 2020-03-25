package com.diet.session.user.data

interface UserDataSource {

    fun isUserLogged(): Boolean

    fun getCurrentUserId() : String

    fun setUserLogged()

    fun setUserId(userId : String)

    fun logOutUser()
}