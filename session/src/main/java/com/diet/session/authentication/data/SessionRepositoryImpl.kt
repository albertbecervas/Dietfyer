package com.diet.session.authentication.data

import com.abecerra.base.data.BaseRepositoryImpl
import com.diet.network.UserService
import com.diet.session.authentication.domain.model.UserForm
import com.diet.session.authentication.domain.repository.SessionRepository
import com.diet.session.authentication.domain.repository.SessionRepositoryOutput
import com.diet.session.user.UserDataSource

class SessionRepositoryImpl(
    private val userService: UserService,
    private val userDataSource: UserDataSource
) :
    BaseRepositoryImpl<SessionRepositoryOutput>(), SessionRepository {

    override fun doLogin(user: UserForm) {
        userService.login(user.username, user.password, {
            userDataSource.setUserLogged()
            output?.onSuccessfulSignIn()
        }, {
            output?.onErrorSigningIn()
        })
    }

    override fun doSignUpWithEmailAndPassword(user: UserForm) {
        userService.signUpWithEmailAndPassword(user.username, user.password, {
            userDataSource.setUserLogged()
            output?.onSuccessfulSignUp()
        }, {
            output?.onErrorSigningUp()
        })
    }

    override fun saveLoggedUser(user: UserForm) {
        userDataSource.setUserLogged()
    }
}