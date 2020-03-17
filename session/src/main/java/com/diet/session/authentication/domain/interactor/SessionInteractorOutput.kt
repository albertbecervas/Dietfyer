package com.diet.session.authentication.domain.interactor

import android.content.Intent

interface SessionInteractorOutput {

    fun userIsLogged()

    fun userIsSignedUp()

    fun userNameIsEmpty()

    fun passwordIsEmpty()

    fun showUserLoginError()

    fun showUserSignUpError()
}