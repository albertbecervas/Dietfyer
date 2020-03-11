package com.diet.network

import com.google.firebase.auth.FirebaseAuth

class UserServiceImpl : UserService {
    override fun login(userName: String, password: String, success: () -> Unit, error: () -> Unit) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(userName, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    success()
                } else {
                    error()
                }
            }
    }

    override fun signUpWithEmailAndPassword(
        userName: String, password: String, success: () -> Unit, error: () -> Unit
    ) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(userName, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    success()
                } else {
                    error()
                }
            }
    }
}