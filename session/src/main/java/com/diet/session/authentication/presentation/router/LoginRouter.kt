package com.diet.session.authentication.presentation.router

import android.content.Intent
import androidx.fragment.app.Fragment

interface LoginRouter {

    fun onGoogleSignUpClicked(intent: Intent, resultCode: Int, fragment: Fragment)

    fun onUserLogged()
}