package com.diet.session.authentication.domain.interactor

import com.abecerra.base.domain.BaseInteractor
import com.diet.session.authentication.domain.model.User

interface SessionInteractor: BaseInteractor<SessionInteractorOutput> {

    fun login(user: User)

    fun signup(user: User)
}