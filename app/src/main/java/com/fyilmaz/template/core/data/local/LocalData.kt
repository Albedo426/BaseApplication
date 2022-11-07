package com.fyilmaz.template.core.data.local

import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.login.LoginRequest
import com.fyilmaz.template.core.data.dto.login.LoginResponse

interface LocalData {
    fun doLogin(loginRequest: LoginRequest): Result<LoginResponse>
    fun doTest(): Result<List<String>>
}