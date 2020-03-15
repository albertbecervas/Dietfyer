package com.diet.session.authentication.domain.interactor

import android.content.Intent

interface SessionInteractorOutput {

    fun userIsLogged()

    fun userIsSignedUp()

    fun launchGoogleSignInIntent(intent: Intent)

    fun showUserLoginError()

    fun showUserSignUpError()
}