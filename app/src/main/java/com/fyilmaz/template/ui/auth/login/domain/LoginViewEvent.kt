package com.fyilmaz.template.ui.auth.login.domain


sealed class LoginViewEvent {
    object GoToMain : LoginViewEvent()
}