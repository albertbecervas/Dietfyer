package com.diet.session.login.presenter

import android.content.Intent
import com.diet.session.authentication.domain.interactor.SessionInteractor
import com.diet.session.login.router.LoginRouter
import com.diet.session.login.view.LoginFragment
import com.diet.session.login.view.LoginView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class LoginPresenterImplTest {

    @Mock
    private lateinit var sessionInteractor: SessionInteractor

    @Mock
    private lateinit var loginRouter: LoginRouter

    @Mock
    private lateinit var loginView: LoginView

    @Mock
    private lateinit var loginFragment: LoginFragment

    private lateinit var presenter: LoginPresenterImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        `when`(loginView.getViewFragment()).thenReturn(loginFragment)
        presenter = LoginPresenterImpl(loginRouter, sessionInteractor)
        presenter.setView(loginView)
    }

    @Test
    fun onLoginClickedCallsInteractor() {
        presenter.onLoginClicked("", "")
        verify(sessionInteractor, times(1)).login("", "")
    }

    @Test
    fun onSignUpWithEmailClickedCallsRouter() {
        presenter.onSignUpWithEmailClicked()
        verify(loginRouter, times(1)).onSignUpClicked()
    }

    @Test
    fun onSignInWithGoogleClickedCallsInteractor() {
        presenter.onSignInWithGoogleClicked()
        val intent = verify(sessionInteractor, times(1))
            .getGoogleSignInIntent()
        verify(loginRouter).launchGoogleSignIn(intent, LoginFragment.GOOGLE_SIGN_IN, loginFragment)
    }

    @Test
    fun userIsLogged() {
        presenter.userIsLogged()
        verify(loginRouter).onUserLogged()
    }

    @Test
    fun launchGoogleSignInIntent() {

    }

    @Test
    fun onSignInWithGoogleResponse() {
        val intent = mock(Intent::class.java)
        presenter.onSignInWithGoogleResult(intent)
        verify(sessionInteractor, times(1)).onSignInWithGoogleResult(intent)
    }

    @Test
    fun showUsernameEmptyError() {
        presenter.userNameIsEmpty()
        verify(loginView).showErrorOnUsernameField("Required Field")
    }

    @Test
    fun showPasswordEmptyError() {
        presenter.passwordIsEmpty()
        verify(loginView).showErrorOnPasswordField("Required Field")
    }

    @Test
    fun showUserLoginError() {
        presenter.showUserLoginError()
        verify(loginView).showErrorMessage("Login Error")
    }
}