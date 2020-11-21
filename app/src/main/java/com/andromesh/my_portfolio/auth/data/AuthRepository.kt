package com.andromesh.my_portfolio.auth.data

import androidx.lifecycle.MutableLiveData
import com.andromesh.my_portfolio.database.Result
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(private val firebaseDataSourse: FirebaseDataSourse) {

    fun login(email: String, password: String): MutableLiveData<Result<FirebaseUser>> {
        return firebaseDataSourse.login(email, password)
    }

    fun signUp(email: String, password: String): MutableLiveData<Result<FirebaseUser>> {
        return firebaseDataSourse.signUp(email, password)
    }

    fun logout() {
        firebaseDataSourse.logout()
    }

    fun getCurrentUser(): FirebaseUser? {
        return firebaseDataSourse.getCurrentUser()
    }


}