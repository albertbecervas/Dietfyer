package com.diet.session


import android.os.Bundle
import android.view.View
import com.abecerra.base.presentation.BasePresenterFragment

class LoginFragment : BasePresenterFragment<LoginPresenter>(), LoginView {

    override fun getLayout(): Int = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.setView(this)
    }
}
