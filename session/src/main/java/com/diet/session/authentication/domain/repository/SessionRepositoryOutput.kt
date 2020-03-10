package com.diet.session.authentication.domain.repository

interface SessionRepositoryOutput {

    fun onSuccessFulSignIn()

    fun onErrorSigningIn()
}