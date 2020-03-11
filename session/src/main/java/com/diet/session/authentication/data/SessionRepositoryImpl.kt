package com.diet.session.authentication.data

import com.abecerra.base.data.BaseRepositoryImpl
import com.diet.network.UserService
import com.diet.session.authentication.domain.model.User
import com.diet.session.authentication.domain.repository.SessionRepository
import com.diet.session.authentication.domain.repository.SessionRepositoryOutput

class SessionRepositoryImpl(private val userService: UserService) :
    BaseRepositoryImpl<SessionRepositoryOutput>(), SessionRepository {

    override fun doLogin(user: User) {
        userService.login(user.username, user.password, {
            output?.onSuccessfulSignIn()
        }, {
            output?.onErrorSigningIn()
        })
    }

    override fun doSignUpWithEmailAndPassword(user: User) {
        userService.signUpWithEmailAndPassword(user.username, user.password, {
            output?.onSuccessfulSignUp()
        }, {
            output?.onErrorSigningUp()
        })
    }
}