package com.diet.network.authentication

interface AuthService {

    fun login(userName: String, password: String, success: (id: String) -> Unit, error: () -> Unit)

    fun signUpWithEmailAndPassword(
        userName: String, password: String, success: (id: String) -> Unit, error: () -> Unit
    )

    fun createUserEntry(userId: String)

    fun logout()
}