package com.andromesh.my_portfolio.auth.ui

import android.util.Patterns
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andromesh.my_portfolio.di.CoroutineScropeIO
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class AuthViewModel @Inject constructor(@CoroutineScropeIO private val ioCoroutineScope: CoroutineScope)
    : ViewModel() {

    //-------------------- Email validation end --------------------//

    val emailAddress = MutableLiveData("")

    fun isEmailValid(emailAddress: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()
    }

    val isValidEmail = MediatorLiveData<Boolean>().apply {
        addSource(emailAddress) {
            value = isEmailValid(it)
        }
    }

    //-------------------- Email validation end --------------------//

}