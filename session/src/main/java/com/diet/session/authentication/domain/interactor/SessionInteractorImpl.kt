package com.diet.session.authentication.domain.interactor

import android.content.Intent
import com.abecerra.base.domain.BaseInteractorImpl
import com.diet.session.authentication.domain.model.UserForm
import com.diet.session.authentication.domain.repository.SessionRepository
import com.diet.session.authentication.domain.repository.SessionRepositoryOutput
import com.diet.session.user.UserSession
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

class SessionInteractorImpl(
    private val sessionRepository: SessionRepository,
    private val googleSignInClient: GoogleSignInClient
) : BaseInteractorImpl<SessionInteractorOutput>(), SessionInteractor, SessionRepositoryOutput {

    init {
        sessionRepository.setRepositoryOutput(this)
        UserSession.isLogged = isUserLoggedIn()
    }

    override fun isUserLoggedIn(): Boolean {
        return sessionRepository.checkIfUserIsLoggedIn()
    }

    override fun login(username: String, password: String) {
        if (checkIfFieldsAreValid(username, password)) {
            sessionRepository.doLogin(UserForm(username, password))
        }
    }

    override fun getGoogleSignInIntent(): Intent = googleSignInClient.signInIntent

    override fun signUp(username: String, password: String) {
        if (checkIfFieldsAreValid(username, password)) {
            sessionRepository.doSignUpWithEmailAndPassword(UserForm(username, password))
        }
    }

    override fun saveUserLogged(userId: String) {
        sessionRepository.saveLoggedUser(userId)
    }

    override fun logout() {
        sessionRepository.doLogout()
        googleSignInClient.signOut()
    }

    override fun onSuccessfulSignIn() {
        UserSession.isLogged = true
        output?.userIsLogged()
    }

    override fun onSignInWithGoogleResult(intent: Intent?) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(intent)
        handleGoogleSignInResult(task)
    }

    override fun onSuccessfulSignUp() {
        UserSession.isLogged = true
        output?.userIsSignedUp()
    }

    override fun onErrorSigningIn() {
        UserSession.isLogged = false
        output?.showUserLoginError()
    }

    override fun onErrorSigningUp() {
        UserSession.isLogged = false
        output?.showUserSignUpError()
    }

    private fun handleGoogleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            account?.id?.let {
                saveUserLogged(it)
                output?.userIsLogged()
            }
        } catch (e: ApiException) {
            e.localizedMessage?.let { output?.showUserLoginError() }
        }
    }

    private fun checkIfFieldsAreValid(username: String, password: String): Boolean {
        var valid = true

        if (username.isBlank()) {
            valid = false
            output?.userNameIsEmpty()
        }

        if (password.isBlank()) {
            valid = false
            output?.passwordIsEmpty()
        }
        return valid
    }
}