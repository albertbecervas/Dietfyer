package com.diet.session.authentication.domain.interactor

import com.abecerra.base.domain.BaseInteractorImpl
import com.diet.session.authentication.domain.model.User
import com.diet.session.authentication.domain.repository.SessionRepository
import com.diet.session.authentication.domain.repository.SessionRepositoryOutput

class SessionInteractorImpl(private val sessionRepository: SessionRepository) :
    BaseInteractorImpl<SessionInteractorOutput>(), SessionInteractor, SessionRepositoryOutput {

    init {
        sessionRepository.setRepositoryOutput(this)
    }

    override fun login(user: User) {
        sessionRepository.doLogin(user)
    }

    override fun signup(user: User) {
        sessionRepository.doSignUpWithEmailAndPassword(user)
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