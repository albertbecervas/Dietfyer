package com.diet.session.login.view


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.abecerra.base.presentation.BasePresenterFragment
import com.diet.session.R
import com.diet.session.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.fragment_login.*

open class LoginFragment : BasePresenterFragment<LoginPresenter>(R.layout.fragment_login), LoginView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.setView(this)

        initViews()
    }

    private fun initViews() {
        bt_login.setOnClickListener {
            presenter?.onLoginClicked(et_username.text.toString(), et_password.text.toString())
        }
        bt_signup.setOnClickListener {
            presenter?.onSignUpWithEmailClicked()
        }
        bt_signin_google.setOnClickListener {
            presenter?.onSignInWithGoogleClicked()
        }
    }

    override fun getViewFragment(): Fragment? = this

    override fun showErrorOnUsernameField(errorMessage: String) {
        et_username.error = errorMessage
    }

    override fun showErrorOnPasswordField(errorMessage: String) {
        et_password.error = errorMessage
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GOOGLE_SIGN_IN) {
            presenter?.onSignInWithGoogleResult(data)
        }
    }

    companion object {
        const val GOOGLE_SIGN_IN: Int = 10
    }
}
