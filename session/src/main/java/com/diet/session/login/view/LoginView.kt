package com.diet.session.login.view

import androidx.fragment.app.Fragment
import com.abecerra.base.presentation.BaseView

interface LoginView : BaseView {

    fun getViewFragment(): Fragment?

    fun showErrorOnUsernameField(errorMessage: String)

    fun showErrorOnPasswordField(errorMessage: String)
}