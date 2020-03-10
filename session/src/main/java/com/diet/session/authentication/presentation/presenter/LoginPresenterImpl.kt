package com.diet.session.authentication.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.diet.session.authentication.domain.interactor.LoginInteractor
import com.diet.session.authentication.domain.interactor.LoginInteractorOutput
import com.diet.session.authentication.domain.model.User
import com.diet.session.authentication.presentation.router.LoginRouter
import com.diet.session.authentication.presentation.view.LoginView

class LoginPresenterImpl(
    private val router: LoginRouter,
    private val loginInteractor: LoginInteractor
) : BasePresenterImpl<LoginView>(), LoginPresenter, LoginInteractorOutput {

    init {
        loginInteractor.setInteractorOutput(this)
    }

    override fun onLoginClicked(username: String, password: String) {
        loginInteractor.login(User(username, password))
    }

    override fun onSignInWithEmailClicked() {
    }

    override fun userIsLogged() {
        router.onUserLogged()
    }

    override fun showUserLoginError() {
        this.getView()?.showLoginError()
    }
}