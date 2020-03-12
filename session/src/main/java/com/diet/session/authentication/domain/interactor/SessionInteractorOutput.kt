package com.diet.session.authentication.domain.interactor

interface SessionInteractorOutput {

    fun userIsLogged()

    fun userIsSignedUp()

    fun showUserLoginError()

    fun showUserSignUpError()
}