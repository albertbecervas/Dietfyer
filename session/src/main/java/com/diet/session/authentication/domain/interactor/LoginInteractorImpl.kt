package com.diet.session.authentication.domain.interactor

import com.abecerra.base.domain.BaseInteractorImpl
import com.diet.session.authentication.domain.model.User
import com.diet.session.authentication.domain.repository.SessionRepository
import com.diet.session.authentication.domain.repository.SessionRepositoryOutput

class LoginInteractorImpl(private val sessionRepository: SessionRepository) :
    BaseInteractorImpl<LoginInteractorOutput>(), LoginInteractor, SessionRepositoryOutput {

    init {
        sessionRepository.setRepositoryOutput(this)
    }

    override fun login(user: User) {
        sessionRepository.doLogin(user)
    }

    override fun onSuccessFulSignIn() {
        output?.userIsLogged()
    }

    override fun onErrorSigningIn() {
        output?.showUserLoginError()
    }
}