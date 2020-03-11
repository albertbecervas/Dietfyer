package com.diet.session.authentication.presentation.presenter

import android.content.Intent
import androidx.fragment.app.Fragment
import com.abecerra.base.presentation.BasePresenterImpl
import com.diet.session.authentication.domain.interactor.SessionInteractor
import com.diet.session.authentication.domain.interactor.SessionInteractorOutput
import com.diet.session.authentication.domain.model.User
import com.diet.session.authentication.presentation.router.LoginRouter
import com.diet.session.authentication.presentation.view.LoginFragment.Companion.GOOGLE_SIGN_IN
import com.diet.session.authentication.presentation.view.LoginView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

class LoginPresenterImpl(
    private val router: LoginRouter,
    private val sessionInteractor: SessionInteractor,
    private val firebaseClientId: String
) : BasePresenterImpl<LoginView>(), LoginPresenter, SessionInteractorOutput {

    init {
        sessionInteractor.setInteractorOutput(this)
    }

    override fun onLoginClicked(username: String, password: String) {
        sessionInteractor.login(User(username, password))
    }

    override fun onSignUpWithEmailClicked(username: String, password: String) {
        sessionInteractor.signup(User(username, password))
    }

    override fun onSignInWithGoogleClicked() {
        val gso: GoogleSignInOptions = GoogleSignInOptions.Builder(
            GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestIdToken(firebaseClientId).requestEmail().build()
        (this.getView() as? Fragment)?.let { fragment ->
            fragment.activity?.let {
                val mGoogleSignInClient = GoogleSignIn.getClient(it, gso);
                val signInIntent: Intent = mGoogleSignInClient.signInIntent
                router.onGoogleSignUpClicked(signInIntent, GOOGLE_SIGN_IN, fragment)
            }
        }
    }

    override fun userIsLogged() {
        this.getView()?.showErrorMessage("Login ok")
    }

    override fun userIsSignedUp() {
        this.getView()?.showErrorMessage("Signup OK")
    }

    override fun onSignInWithGoogleResponse(data: Intent?) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        handleGoogleSignInResult(task)
    }

    override fun showUserLoginError() {
        this.getView()?.showErrorMessage("Login Error")
    }

    override fun showUserSignUpError() {
        this.getView()?.showErrorMessage("Signup Error")
    }

    private fun handleGoogleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            router.onUserLogged()
        } catch (e: ApiException) {
            e.localizedMessage?.let {
                this.getView()?.showErrorMessage(it)
            }
        }
    }
}