package com.fyilmaz.template.ui.auth.login.domain

import android.annotation.SuppressLint
import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fyilmaz.template.core.extensions.Event
import com.fyilmaz.template.core.platform.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel() {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val enabled: MediatorLiveData<Boolean> = MediatorLiveData<Boolean>().apply {
        fun validateInputs(): Boolean {
            return (
                !username.value.isNullOrEmpty() &&
                    !password.value.isNullOrEmpty()
                )
        }
        addSource(username) { value = validateInputs() }
        addSource(password) { value = validateInputs() }
    }
    private val _event = MutableLiveData<Event<LoginViewEvent>>()
    val event: LiveData<Event<LoginViewEvent>> = _event

    fun loginRegister() {
        viewModelScope.launch {
            // login işlemi gelecek
            _event.postValue(Event(LoginViewEvent.GoToMain))
        }
    }

}
