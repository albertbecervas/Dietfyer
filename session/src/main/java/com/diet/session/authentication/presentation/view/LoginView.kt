package com.diet.session.authentication.presentation.view

import com.abecerra.base.presentation.BaseView

interface LoginView : BaseView {

    fun showErrorOnUsernameField(errorMessage: String)
    fun showErrorOnPasswordField(errorMessage: String)
}