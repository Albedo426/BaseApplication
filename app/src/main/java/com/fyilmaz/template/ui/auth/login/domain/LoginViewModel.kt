package com.fyilmaz.template.ui.auth.login.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.login.LoginRequest
import com.fyilmaz.template.ui.auth.login.domain.usecase.UseCaseLogin
import com.fyilmaz.template.core.extensions.Event
import com.fyilmaz.template.core.platform.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val useCaseLogin: UseCaseLogin) : BaseViewModel() {

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

    fun doLogin() {
        setLoading(true)
        viewModelScope.launch {
            // login işlemi gelecek
            // nullsafe için sistem eklenecek
            useCaseLogin.login(LoginRequest(username.value!!, password.value!!)).collect {
                when (it) {
                    is Result.Error -> it.exception?.let { it1 -> handleException(it1) }
                    is Result.Success -> _event.postValue(Event(LoginViewEvent.GoToMain))
                }
                setLoading(false)
                // token save vb
            }
        }
    }
}
