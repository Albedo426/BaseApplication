package com.fyilmaz.template.ui.auth.login.domain

import com.fyilmaz.template.core.data.dto.login.LoginResponse


sealed class LoginViewEvent {
    data class GoToMain(val item: LoginResponse) : LoginViewEvent()
}