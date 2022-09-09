package com.fyilmaz.template.core.data.dto.login

data class LoginResponse(
    val id: String? = null,
    val firstName: String,
    val lastName: String,
    val email: String,
    val token: String
)
