package com.diet.session.login.router

import android.content.Intent
import androidx.fragment.app.Fragment

interface LoginRouter {

    fun launchGoogleSignIn(intent: Intent, resultCode: Int, fragment: Fragment)

    fun onSignUpClicked()

    fun onUserLogged()
}