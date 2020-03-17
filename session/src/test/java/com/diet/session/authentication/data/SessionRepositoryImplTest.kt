package com.diet.session.authentication.data

import com.diet.network.authentication.AuthService
import com.diet.session.authentication.domain.model.UserForm
import com.diet.session.authentication.domain.repository.SessionRepositoryOutput
import com.diet.session.user.UserDataSource
import com.nhaarman.mockito_kotlin.any
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class SessionRepositoryImplTest {

    @Mock
    private lateinit var authService: AuthService

    @Mock
    private lateinit var userDataSource: UserDataSource

    @Mock
    private lateinit var output: SessionRepositoryOutput

    private lateinit var sessionRepositoryImpl: SessionRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        sessionRepositoryImpl = SessionRepositoryImpl(authService, userDataSource)
        sessionRepositoryImpl.setRepositoryOutput(output)
    }

    @Test
    fun checkIfUserIsLoggedInWhenUserIsLogged() {
        Mockito.`when`(userDataSource.isUserLogged()).thenReturn(true)
        val isLogged = sessionRepositoryImpl.checkIfUserIsLoggedIn()
        assert(isLogged)
    }

    @Test
    fun checkIfUserIsLoggedInWhenUserIsNotLogged() {
        Mockito.`when`(userDataSource.isUserLogged()).thenReturn(false)
        val isLogged = sessionRepositoryImpl.checkIfUserIsLoggedIn()
        assertFalse(isLogged)
    }

    @Test
    fun doLogin() {
        sessionRepositoryImpl.doLogin(UserForm("", ""))
        verify(authService).login(any(), any(), any(), any())
    }

    @Test
    fun doSignUpWithEmailAndPassword() {
        sessionRepositoryImpl.doSignUpWithEmailAndPassword(UserForm("", ""))
        verify(authService).signUpWithEmailAndPassword(any(), any(), any(), any())
    }

    @Test
    fun saveLoggedUser() {
        sessionRepositoryImpl.saveLoggedUser("")
        verify(userDataSource).setUserLogged()
        verify(authService).createUserEntry(any())
    }

    @Test
    fun doLogout() {
        sessionRepositoryImpl.doLogout()
        verify(userDataSource).logOutUser()
        verify(authService).logout()
    }
}