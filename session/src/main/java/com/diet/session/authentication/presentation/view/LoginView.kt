package com.diet.session.authentication.presentation.view

import androidx.fragment.app.Fragment
import com.abecerra.base.presentation.BaseView

interface LoginView : BaseView {

    fun getViewFragment(): Fragment?

    fun showErrorOnUsernameField(errorMessage: String)

    fun showErrorOnPasswordField(errorMessage: String)
}