package com.diet.session.authentication.presentation.presenter

import android.content.Intent
import com.abecerra.base.presentation.BasePresenterImpl
import com.diet.session.authentication.domain.interactor.SessionInteractor
import com.diet.session.authentication.domain.interactor.SessionInteractorOutput
import com.diet.session.authentication.presentation.router.LoginRouter
import com.diet.session.authentication.presentation.view.LoginFragment.Companion.GOOGLE_SIGN_IN
import com.diet.session.authentication.presentation.view.LoginView

class LoginPresenterImpl(
    private val router: LoginRouter,
    private val sessionInteractor: SessionInteractor
) : BasePresenterImpl<LoginView>(), LoginPresenter, SessionInteractorOutput {

    init {
        sessionInteractor.setInteractorOutput(this)
    }

    override fun onLoginClicked(username: String, password: String) {
        sessionInteractor.login(username, password)
    }

    override fun onSignUpWithEmailClicked() {
        router.onSignUpClicked()
    }

    override fun onSignInWithGoogleClicked() {
        sessionInteractor.signInWithGoogle()
    }

    override fun userIsLogged() {
        router.onUserLogged()
    }

    override fun userIsSignedUp() {
        router.onUserLogged()
    }

    override fun launchGoogleSignInIntent(intent: Intent) {
        this.getView()?.getViewFragment()?.let {
            router.launchGoogleSignIn(intent, GOOGLE_SIGN_IN, it)
        }

    }

    override fun onSignInWithGoogleResult(data: Intent?) {
        sessionInteractor.onSignInWithGoogleResult(data)
    }

    override fun userNameIsEmpty() {
        getView()?.showErrorOnUsernameField("Required Field")
    }

    override fun passwordIsEmpty() {
        getView()?.showErrorOnPasswordField("Required Field")
    }

    override fun showUserLoginError() {
        showError("Login Error")
    }

    override fun showUserSignUpError() {
        showError("Signup Error")
    }
}