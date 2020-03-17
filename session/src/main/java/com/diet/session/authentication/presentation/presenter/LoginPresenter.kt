package com.diet.session.authentication.presentation.presenter

import android.content.Intent
import com.abecerra.base.presentation.BasePresenter
import com.diet.session.authentication.presentation.view.LoginView

interface LoginPresenter : BasePresenter<LoginView> {

    fun onLoginClicked(username: String, password: String)

    fun onSignUpWithEmailClicked()

    fun onSignInWithGoogleClicked()

    fun onSignInWithGoogleResult(data: Intent?)
}