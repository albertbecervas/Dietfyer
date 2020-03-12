package com.diet.network

interface UserService {

    fun login(userName: String, password: String, success: () -> Unit, error: () -> Unit)

    fun signUpWithEmailAndPassword(
        userName: String, password: String, success: () -> Unit, error: () -> Unit
    )
}