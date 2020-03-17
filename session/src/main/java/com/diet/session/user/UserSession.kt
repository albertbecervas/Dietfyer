package com.diet.session.user

import com.diet.session.user.data.User

object UserSession {
    var isLogged: Boolean = false
    var user: User? = null
}