package com.diet.network.authentication

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AuthServiceImpl : AuthService {
    override fun login(
        userName: String,
        password: String,
        success: (id: String) -> Unit,
        error: () -> Unit
    ) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(userName, password)
            .addOnCompleteListener {
                handleIfUserIsLogged(it, success, error)
            }
    }

    override fun signUpWithEmailAndPassword(
        userName: String, password: String, success: (id: String) -> Unit, error: () -> Unit
    ) {
        FirebaseAuth.getInstance().signOut()
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(userName, password)
            .addOnCompleteListener {
                handleIfUserIsLogged(it, success, error)
            }
    }

    override fun createUserEntry(userId: String) {
        val map = hashMapOf<String, Any?>()
        map["id"] = userId
        FirebaseFirestore.getInstance().collection("users")
            .document("$userId")
            .set(map)
    }

    override fun logout() {
        FirebaseAuth.getInstance().signOut()
    }

    private fun handleIfUserIsLogged(
        it: Task<AuthResult>, success: (id: String) -> Unit, error: () -> Unit
    ) {
        if (it.isSuccessful) {
            it.result?.user?.uid?.let { uid ->
                success(uid)
            }?.runCatching {
                error()
            }
        } else error()
    }
}