package com.diet.session.authentication.presentation.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.diet.session.authentication.domain.interactor.SessionInteractor
import com.diet.session.authentication.presentation.presenter.LoginPresenter
import com.diet.session.authentication.presentation.presenter.LoginPresenterImpl
import com.diet.session.authentication.presentation.router.LoginRouter
import org.mockito.Mockito

class LoginFragmentFactory : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val router: LoginRouter = Mockito.mock(LoginRouter::class.java)
        val interactor: SessionInteractor = Mockito.mock(SessionInteractor::class.java)
        val presenter: LoginPresenter = LoginPresenterImpl(router, interactor)
        val fragment = LoginFragment()
        fragment.injectPresenter(presenter)
        return fragment
    }
}