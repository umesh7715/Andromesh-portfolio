package com.andromesh.my_portfolio.auth.data

import androidx.lifecycle.MutableLiveData
import com.andromesh.my_portfolio.database.Result
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject


class FirebaseDataSourse @Inject constructor() {

    private val auth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    fun login(email: String, password: String): MutableLiveData<Result<com.google.firebase.auth.FirebaseUser>> {

        val authenticatedUserMutableLiveData: MutableLiveData<Result<com.google.firebase.auth.FirebaseUser>> = MutableLiveData()

        authenticatedUserMutableLiveData.value = Result.loading()
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        authenticatedUserMutableLiveData.value = Result.success(user!!)

                    } else {
                        authenticatedUserMutableLiveData.value = Result.error(task.exception?.localizedMessage!!)
                    }
                }

        return authenticatedUserMutableLiveData
    }

    fun signUp(email: String, password: String): MutableLiveData<Result<com.google.firebase.auth.FirebaseUser>> {

        val authenticatedUserMutableLiveData: MutableLiveData<Result<com.google.firebase.auth.FirebaseUser>> = MutableLiveData()

        authenticatedUserMutableLiveData.value = Result.loading()

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        authenticatedUserMutableLiveData.value = Result.success(user!!)
                    } else {
                        authenticatedUserMutableLiveData.value = Result.error(task.exception?.localizedMessage!!)
                    }

                }

        return authenticatedUserMutableLiveData
    }

    fun logout() {

        auth.signOut()


    }

    fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }
}

