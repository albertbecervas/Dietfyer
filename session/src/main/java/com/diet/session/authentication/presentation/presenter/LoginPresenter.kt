package com.diet.session.authentication.presentation.presenter

import android.content.Intent
import com.abecerra.base.presentation.BasePresenter
import com.diet.session.authentication.presentation.view.LoginView

interface LoginPresenter : BasePresenter<LoginView> {

    fun onLoginClicked(username: String, password: String)

    fun onSignUpWithEmailClicked(username: String, password: String)

    fun onSignInWithGoogleClicked()

    fun onSignInWithGoogleResponse(data: Intent?)
}