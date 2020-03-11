package com.diet.session.authentication.domain.repository

import com.abecerra.base.data.BaseRepository
import com.diet.session.authentication.domain.model.User

interface SessionRepository : BaseRepository<SessionRepositoryOutput> {

    fun doLogin(user: User)

    fun doSignUpWithEmailAndPassword(user: User)
}