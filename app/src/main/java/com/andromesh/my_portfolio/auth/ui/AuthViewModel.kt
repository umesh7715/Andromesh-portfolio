package com.andromesh.my_portfolio.auth.ui

import android.util.Patterns
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andromesh.my_portfolio.auth.data.AuthRepository
import com.andromesh.my_portfolio.data.Result
import com.andromesh.my_portfolio.di.CoroutineScropeIO
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import java.util.regex.Pattern
import javax.inject.Inject


class AuthViewModel @Inject constructor(private val authRepository: AuthRepository,
                                        @CoroutineScropeIO private val ioCoroutineScope: CoroutineScope)
    : ViewModel() {


    var user = MutableLiveData<Result<FirebaseUser>>()

    //-------------------- Email validation end --------------------//

    val emailAddress = MutableLiveData("")
    val password = MutableLiveData("")
    val confirmPassword = MutableLiveData("")
    private lateinit var tempPassword: String


    fun isEmailValid(emailAddress: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()
    }

    val isValidEmail = MediatorLiveData<Boolean>().apply {
        addSource(emailAddress) {
            value = isEmailValid(it)
        }
    }

    //-------------------- Email validation end --------------------//


    //-------------------- password validation starts --------------//

    private val PASSWORD_REGEX = "^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#\$%^&+=])"

    fun isEmpty(passwordString: String): Boolean {
        return passwordString.isNotEmpty()
    }

    val isEmptyValid = MediatorLiveData<Boolean>().apply {
        addSource(password) {
            value = isEmpty(it)
        }

    }

    fun isNumberPresent(passwordString: String): Boolean {
        return Pattern.compile("^(?=.*[0-9])").matcher(passwordString).find()
    }

    val isNumberPresentValid = MediatorLiveData<Boolean>().apply {
        addSource(password) {
            value = isNumberPresent(it)
        }
    }

    fun isSpecialCharacterPresent(passwordString: String): Boolean {
        return Pattern.compile("^(?=.*[@#\$%^&+=])").matcher(passwordString).find()
    }

    val isSpecialCharacterPresentValid = MediatorLiveData<Boolean>().apply {
        addSource(password) {
            value = isSpecialCharacterPresent(it)
        }
    }

    fun isCapitalPresent(passwordString: String): Boolean {
        return Pattern.compile("^(?=.*[A-Z])").matcher(passwordString).find()
    }

    val isCapitalPresentValid = MediatorLiveData<Boolean>().apply {
        addSource(password) {
            value = isCapitalPresent(it)
        }
    }

    fun isSmallPresent(passwordString: String): Boolean {
        return Pattern.compile("^(?=.*[a-z])").matcher(passwordString).find()
    }

    val isSmallPresentValid = MediatorLiveData<Boolean>().apply {
        addSource(password) {
            value = isSmallPresent(it)
        }
    }

    fun isEightCharPresent(passwordString: String): Boolean {
        return Pattern.compile("^(?=.{8,})").matcher(passwordString).find()
    }

    val isEightCharPresentValid = MediatorLiveData<Boolean>().apply {
        addSource(password) {
            value = isEightCharPresent(it)
        }
    }

    fun isPassword(passwordString: String): Boolean {
        return Pattern.compile(PASSWORD_REGEX).matcher(passwordString).find()
    }

    val isPasswordValid = MediatorLiveData<Boolean>().apply {
        addSource(password) {
            tempPassword = it
            value = isPassword(it)
        }
    }

    fun isConfirmPassword(passwordString: String): Boolean {
        return passwordString.isNotEmpty() && tempPassword.equals(passwordString, true)
    }

    val isConfirmPasswordValid = MediatorLiveData<Boolean>().apply {

        addSource(confirmPassword) {
            value = isConfirmPassword(it)
        }
    }

    fun login(email: String, password: String) {
        user = authRepository.login(email, password)
    }

    fun signUp(email: String, password: String) {
        user = authRepository.signUp(email, password)
    }


    //-------------------- password validation ends --------------//

}