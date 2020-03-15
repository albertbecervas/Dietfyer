package com.diet.session.authentication.domain.repository

import com.abecerra.base.data.BaseRepository
import com.diet.session.authentication.domain.model.UserForm

interface SessionRepository : BaseRepository<SessionRepositoryOutput> {

    fun doLogin(user: UserForm)

    fun doSignUpWithEmailAndPassword(user: UserForm)

    fun saveLoggedUser(userId: String)

    fun doLogout()

    fun checkIfUserIsLoggedIn(): Boolean
}