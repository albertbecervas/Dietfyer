package com.diet.session.authentication.presentation.presenter

import android.content.Intent
import androidx.fragment.app.Fragment
import com.abecerra.base.presentation.BasePresenterImpl
import com.diet.session.authentication.domain.interactor.SessionInteractor
import com.diet.session.authentication.domain.interactor.SessionInteractorOutput
import com.diet.session.authentication.domain.model.UserForm
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
        if (checkIfLoginFieldsAreValid(username, password)) {
            sessionInteractor.login(UserForm(username, password))
        }
    }

    override fun onSignUpWithEmailClicked(username: String, password: String) {
        sessionInteractor.signUp(UserForm(username, password))
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
        (this.getView() as? Fragment)?.let { fragment ->
            router.onGoogleSignUpClicked(intent, GOOGLE_SIGN_IN, fragment)
        }
    }

    override fun onSignInWithGoogleResponse(data: Intent?) {
        sessionInteractor.onSignInWithGoogleResult(data)
    }

    override fun showUserLoginError() {
        showError("Login Error")
    }

    override fun showUserSignUpError() {
        showError("Signup Error")
    }

    private fun checkIfLoginFieldsAreValid(username: String, password: String): Boolean {
        var valid = true

        if (username.isBlank()) {
            valid = false
            getView()?.showErrorOnUsernameField("Required Field")
        }

        if (password.isBlank()) {
            valid = false
            getView()?.showErrorOnPasswordField("Required Field")
        }
        return valid
    }
}