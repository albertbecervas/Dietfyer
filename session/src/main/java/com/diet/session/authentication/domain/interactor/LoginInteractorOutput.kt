package com.diet.session.authentication.domain.interactor

interface LoginInteractorOutput {

    fun userIsLogged()

    fun showUserLoginError()
}