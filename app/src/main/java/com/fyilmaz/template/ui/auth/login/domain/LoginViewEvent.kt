package com.fyilmaz.template.ui.auth.login.domain

import com.fyilmaz.template.core.data.dto.login.LoginResponse
import com.fyilmaz.template.ui.main.home.domain.HomeViewEvent


sealed class LoginViewEvent {
    data class GoToMain(val item: LoginResponse) : LoginViewEvent()
    object GoReturn : LoginViewEvent()
}