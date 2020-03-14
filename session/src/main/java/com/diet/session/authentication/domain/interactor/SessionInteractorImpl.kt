package com.diet.session.authentication.domain.interactor

import com.abecerra.base.domain.BaseInteractorImpl
import com.diet.session.authentication.domain.model.UserForm
import com.diet.session.authentication.domain.repository.SessionRepository
import com.diet.session.authentication.domain.repository.SessionRepositoryOutput

class SessionInteractorImpl(private val sessionRepository: SessionRepository) :
    BaseInteractorImpl<SessionInteractorOutput>(), SessionInteractor, SessionRepositoryOutput {

    init {
        sessionRepository.setRepositoryOutput(this)
    }

    override fun login(user: UserForm) {
        sessionRepository.doLogin(user)
    }

    override fun signUp(user: UserForm) {
        sessionRepository.doSignUpWithEmailAndPassword(user)
    }

    override fun saveUserLogged(user: UserForm) {
        sessionRepository.saveLoggedUser(user)
    }

    override fun onSuccessfulSignIn() {
        output?.userIsLogged()
    }

    override fun onSuccessfulSignUp() {
        output?.userIsSignedUp()
    }

    override fun onErrorSigningIn() {
        output?.showUserLoginError()
    }

    override fun onErrorSigningUp() {
        output?.showUserSignUpError()
    }
}