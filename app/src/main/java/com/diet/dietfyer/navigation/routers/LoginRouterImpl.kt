package com.diet.dietfyer.navigation.routers

import android.content.Intent
import androidx.fragment.app.Fragment
import com.diet.dietfyer.navigation.navigator.Navigator
import com.diet.dietfyer.scenes.main.view.MainActivity
import com.diet.session.authentication.presentation.router.LoginRouter
import com.diet.session.authentication.presentation.view.LoginFragment

class LoginRouterImpl(private val navigator: Navigator) : LoginRouter {

    override fun onGoogleSignUpClicked(intent: Intent, resultCode: Int, fragment: Fragment) {
        navigator.startActivityForResult(intent, LoginFragment.GOOGLE_SIGN_IN, fragment)
    }

    override fun onUserLogged() {
        navigator.startActivity(MainActivity::class.java)
    }
}