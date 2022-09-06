package com.fyilmaz.template.core.data.usecase.login

import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.login.LoginRequest
import com.fyilmaz.template.core.data.dto.login.LoginResponse
import kotlinx.coroutines.flow.Flow

interface UseCaseLogin {
    suspend fun login(login: LoginRequest): Flow<Result<LoginResponse>>
}
