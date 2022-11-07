package com.fyilmaz.template.core.data.usecase.user

import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.login.LoginRequest
import com.fyilmaz.template.core.data.dto.login.LoginResponse
import kotlinx.coroutines.flow.Flow

interface UserUseCase {
    suspend fun login(login: LoginRequest): Flow<Result<LoginResponse>>
    suspend fun getListForTest(): Flow<Result<List<String>>>
}
