package com.diet.session


import android.os.Bundle
import android.view.View
import com.diet.base.PresenterConfigurator
import com.diet.base.presentation.BasePresenterFragment

class LoginFragment(presenterConfigurator: PresenterConfigurator<LoginPresenter>) :
    BasePresenterFragment<LoginPresenter>(presenterConfigurator), LoginView {

    override fun getLayout(): Int = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPresenter()?.setView(this)
    }
}
