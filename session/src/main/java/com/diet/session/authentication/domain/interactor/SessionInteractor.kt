package com.diet.session.authentication.domain.interactor

import android.content.Intent
import com.abecerra.base.domain.BaseInteractor
import com.diet.session.authentication.domain.model.UserForm

interface SessionInteractor : BaseInteractor<SessionInteractorOutput> {

    fun login(username: String, password: String)

    fun signInWithGoogle()

    fun onSignInWithGoogleResult(intent: Intent?)

    fun signUp(username: String, password: String)

    fun saveUserLogged(userId: String)

    fun logout()

    fun isUserLoggedIn(): Boolean
}