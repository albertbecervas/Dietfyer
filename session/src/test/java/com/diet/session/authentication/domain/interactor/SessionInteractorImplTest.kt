package com.diet.session.authentication.domain.interactor

import com.diet.session.authentication.domain.model.UserForm
import com.diet.session.authentication.domain.repository.SessionRepository
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.nhaarman.mockito_kotlin.any
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class SessionInteractorImplTest {

    private lateinit var sessionRepository: SessionRepository

    @Mock
    private lateinit var googleSignInClient: GoogleSignInClient

    @Mock
    private lateinit var sessionInteractorOutput: SessionInteractorOutput

    private lateinit var sessionInteractorImpl: SessionInteractorImpl

    private val username: String = "testUsername"

    private val password: String = "testPassword"

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        sessionRepository = spy(SessionRepository::class.java)
        sessionInteractorImpl = SessionInteractorImpl(sessionRepository, googleSignInClient)
        sessionInteractorImpl.setInteractorOutput(sessionInteractorOutput)
    }

    @Test
    fun isUserLoggedInReturnsTrueIfUseIsLogged() {
        // Given: The user is logged
        `when`(sessionRepository.checkIfUserIsLoggedIn()).thenReturn(true)

        // When: The method to check if is user logged in is executed
        val isLogged = sessionInteractorImpl.isUserLoggedIn()

        // Then: The repository is called to check if user is logged and this returns true
        assert(isLogged)
    }

    @Test
    fun isUserLoggedInReturnsFalseIfUseIsNotLogged() {
        // Given: The user is not logged
        `when`(sessionRepository.checkIfUserIsLoggedIn()).thenReturn(false)

        // When: The method to check if is user logged in is executed
        val isLogged = sessionInteractorImpl.isUserLoggedIn()

        // Then: The repository is called to check if user is logged and this returns false
        assertFalse(isLogged)
    }

    @Test
    fun loginReturnsErrorIfUsernameEmptyField() {
        // When: User executes login with empty username
        sessionInteractorImpl.login("", password)

        // Then: The login call is not executed and the output notifies an error
        verify(sessionRepository, times(0)).doLogin(any())
        verify(sessionInteractorOutput).userNameIsEmpty()
        verify(sessionInteractorOutput, times(0)).passwordIsEmpty()
    }

    @Test
    fun loginReturnsErrorIfPasswordEmptyField() {
        // When: User executes login with empty password
        sessionInteractorImpl.login(username, "")

        // Then: The login call is not executed and the output notifies an error
        verify(sessionRepository, times(0)).doLogin(any())
        verify(sessionInteractorOutput, times(0)).userNameIsEmpty()
        verify(sessionInteractorOutput).passwordIsEmpty()
    }

    @Test
    fun loginCallsRepositoryIfUsernameAndPasswordAreCorrect() {
        // When: User executes login with correct fields
        sessionInteractorImpl.login(username, password)

        // Then: The login call is executed
        verify(sessionRepository).doLogin(UserForm(username, password))
        verify(sessionInteractorOutput, times(0)).userNameIsEmpty()
        verify(sessionInteractorOutput, times(0)).passwordIsEmpty()
    }

    @Test
    fun signUpReturnsErrorIfUsernameEmptyField() {
        // When: User executes sign up with empty username
        sessionInteractorImpl.signUp("", password)

        // Then: The sign up call is not executed and the output notifies an error
        verify(sessionRepository, times(0)).doSignUpWithEmailAndPassword(any())
        verify(sessionInteractorOutput).userNameIsEmpty()
        verify(sessionInteractorOutput, times(0)).passwordIsEmpty()
    }

    @Test
    fun signUpReturnsErrorIfPasswordEmptyField() {
        // When: User executes sign up with empty password
        sessionInteractorImpl.signUp(username, "")

        // Then: The sign up call is not executed and the output notifies an error
        verify(sessionRepository, times(0)).doSignUpWithEmailAndPassword(any())
        verify(sessionInteractorOutput, times(0)).userNameIsEmpty()
        verify(sessionInteractorOutput).passwordIsEmpty()
    }

    @Test
    fun signUpCallsRepositoryIfUsernameAndPasswordAreCorrect() {
        // When: User executes sign up with correct fields
        sessionInteractorImpl.signUp(username, password)

        // Then: The sign up call is executed
        verify(sessionRepository).doSignUpWithEmailAndPassword(UserForm(username, password))
        verify(sessionInteractorOutput, times(0)).userNameIsEmpty()
        verify(sessionInteractorOutput, times(0)).passwordIsEmpty()
    }

    @Test
    fun saveUserLogged() {
        // Give: A user Id
        val userId = "id_test"

        // When: Save user logged is required
        sessionInteractorImpl.saveUserLogged(userId)

        // Then: The repository is called to save the user
        verify(sessionRepository).saveLoggedUser(userId)
    }

    @Test
    fun logout() {
        // When: The logout method is called
        sessionInteractorImpl.logout()

        // Then: the repository and de google client are called to sign out
        verify(sessionRepository).doLogout()
        verify(googleSignInClient).signOut()
    }

    @Test
    fun onSuccessfulSignIn() {
        // When: The Sign in is successful
        sessionInteractorImpl.onSuccessfulSignIn()

        // Then: the output notifies the success
        verify(sessionInteractorOutput).userIsLogged()
    }

    @Test
    fun onSuccessfulSignUp() {
        // When: The Sign up is successful
        sessionInteractorImpl.onSuccessfulSignUp()

        // Then: the output notifies the success
        verify(sessionInteractorOutput).userIsSignedUp()
    }

    @Test
    fun onErrorSigningIn() {
        // When: An error occurred signing in
        sessionInteractorImpl.onErrorSigningIn()

        // Then: The output notifies the error
        verify(sessionInteractorOutput).showUserLoginError()
    }

    @Test
    fun onErrorSigningUp() {
        // When: An error occurred signing up
        sessionInteractorImpl.onErrorSigningUp()

        // Then: The output notifies the error
        verify(sessionInteractorOutput).showUserSignUpError()
    }
}