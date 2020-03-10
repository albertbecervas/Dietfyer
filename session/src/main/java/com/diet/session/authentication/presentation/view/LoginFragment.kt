package com.diet.session.authentication.presentation.view


import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.abecerra.base.presentation.BasePresenterFragment
import com.diet.session.authentication.presentation.presenter.LoginPresenter
import com.diet.session.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BasePresenterFragment<LoginPresenter>(),
    LoginView {

    override fun getLayout(): Int = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.setView(this)

        initViews()
    }

    private fun initViews() {
        tv_login.setOnClickListener {
            presenter?.onLoginClicked(et_username.text.toString(), et_password.text.toString())
        }
    }

    override fun showLoginError() {
        Toast.makeText(this.context, "login error", Toast.LENGTH_LONG).show()
    }
}
