package com.diet.session.authentication.presentation.view


import android.content.Intent
import android.os.Bundle
import android.view.View
import com.abecerra.base.presentation.BasePresenterFragment
import com.diet.session.R
import com.diet.session.authentication.presentation.presenter.LoginPresenter
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BasePresenterFragment<LoginPresenter>(R.layout.fragment_login), LoginView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.setView(this)

        initViews()
    }

    private fun initViews() {
        tv_login.setOnClickListener {
            presenter?.onLoginClicked(et_username.text.toString(), et_password.text.toString())
        }
        tv_signup_mail.setOnClickListener {
            presenter?.onSignUpWithEmailClicked(
                et_username.text.toString(), et_password.text.toString()
            )
        }
        tv_signup_google.setOnClickListener {
            presenter?.onSignInWithGoogleClicked()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GOOGLE_SIGN_IN) {
            presenter?.onSignInWithGoogleResponse(data)
        }
    }

    companion object {
        const val GOOGLE_SIGN_IN: Int = 10
    }
}
