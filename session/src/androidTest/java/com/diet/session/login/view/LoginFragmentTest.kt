package com.diet.session.login.view

import android.content.Intent
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.diet.network.authentication.AuthService
import com.diet.session.R
import com.diet.session.authentication.data.SessionRepositoryImpl
import com.diet.session.authentication.domain.interactor.SessionInteractor
import com.diet.session.authentication.domain.interactor.SessionInteractorImpl
import com.diet.session.authentication.domain.repository.SessionRepository
import com.diet.session.login.presenter.LoginPresenter
import com.diet.session.login.presenter.LoginPresenterImpl
import com.diet.session.login.router.LoginRouter
import com.diet.session.user.data.UserDataSource
import com.diet.session.utils.EditTextViewMatcher.isErrorShown
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class LoginFragmentTest {

    @Mock
    private lateinit var authService: AuthService

    @Mock
    private lateinit var userDataSource: UserDataSource

    @Mock
    private lateinit var googleSignInClient: GoogleSignInClient

    @Mock
    private lateinit var loginRouter: LoginRouter

    private lateinit var sessionRepository: SessionRepository
    private lateinit var sessionInteractor: SessionInteractor
    private lateinit var loginPresenter: LoginPresenter

    private val testUsername = "testUsername"
    private val testPassword = "testPassword"

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        `when`(googleSignInClient.signInIntent).thenReturn(Intent())

        sessionRepository = SessionRepositoryImpl(authService, userDataSource)
        sessionInteractor = SessionInteractorImpl(sessionRepository, googleSignInClient)
        loginPresenter = LoginPresenterImpl(loginRouter, sessionInteractor)
        launchFragmentInContainer<LoginFragment>(factory = LoginFragmentFactory(loginPresenter))
    }

    @Test
    fun testErrorIsShownIfUsernameIsEmptyOnLogin() {
        onView(withId(R.id.bt_login)).perform(click())
        onView(withId(R.id.et_username)).check(matches(isErrorShown()))
    }

    @Test
    fun testErrorIsShownIfPasswordIsEmptyOnLogin() {
        onView(withId(R.id.bt_login)).perform(click())
        onView(withId(R.id.et_password)).check(matches(isErrorShown()))
    }

    @Test
    fun testLoginSuccess_shouldNavigate() {
        createLoginOkResponse()

        onView(withId(R.id.et_username)).perform(replaceText(testUsername))
        onView(withId(R.id.et_password)).perform(replaceText(testPassword))
        onView(withId(R.id.bt_login)).perform(click())
        verify(loginRouter).onUserLogged()
    }

    @Test
    fun testLoginError_shouldNotNavigate() {
        createLoginKoResponse()

        onView(withId(R.id.et_username)).perform(replaceText(testUsername))
        onView(withId(R.id.et_password)).perform(replaceText(testPassword))
        onView(withId(R.id.bt_login)).perform(click())
        verify(loginRouter, times(0)).onUserLogged()
    }

    @Test
    fun testGoogleSignInClicked_shouldNavigate() {
        onView(withId(R.id.bt_signin_google)).perform(click())
        verify(loginRouter).launchGoogleSignIn(any(), ArgumentMatchers.anyInt(), any())
    }

    @Test
    fun testSignUpClicked_shouldNavigate() {
        onView(withId(R.id.bt_signup)).perform(click())
        verify(loginRouter).onSignUpClicked()
    }

    private fun createLoginOkResponse() {
        doAnswer {
            (it.arguments[2] as? (id: String) -> Unit)?.invoke("")
        }.whenever(authService).login(anyString(), anyString(), any(), any())
    }

    private fun createLoginKoResponse() {
        doAnswer {
            (it.arguments[3] as? (id: String) -> Unit)?.invoke("")
        }.whenever(authService).login(anyString(), anyString(), any(), any())
    }
}