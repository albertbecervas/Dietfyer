package com.diet.session.login.presenter

import android.content.Intent
import com.abecerra.base.presentation.BasePresenter
import com.diet.session.login.view.LoginView

interface LoginPresenter : BasePresenter<LoginView> {

    fun onLoginClicked(username: String, password: String)

    fun onSignUpWithEmailClicked()

    fun onSignInWithGoogleClicked()

    fun onSignInWithGoogleResult(data: Intent?)
}