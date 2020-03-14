package com.diet.session.authentication.domain.interactor

import com.abecerra.base.domain.BaseInteractor
import com.diet.session.authentication.domain.model.UserForm

interface SessionInteractor: BaseInteractor<SessionInteractorOutput> {

    fun login(user: UserForm)

    fun signUp(user: UserForm)

    fun saveUserLogged(user: UserForm)
}