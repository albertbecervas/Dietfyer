package com.diet.session.authentication.domain.interactor

import com.abecerra.base.domain.BaseInteractor
import com.diet.session.authentication.domain.model.User

interface LoginInteractor: BaseInteractor<LoginInteractorOutput> {

    fun login(user: User)
}