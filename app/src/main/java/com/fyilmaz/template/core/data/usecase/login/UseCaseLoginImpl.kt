package com.fyilmaz.template.core.data.usecase.login

import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.login.LoginRequest
import com.fyilmaz.template.core.data.dto.login.LoginResponse
import com.fyilmaz.template.core.data.local.LocalData
import com.fyilmaz.template.core.data.repository.RemoteDataRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UseCaseLoginImpl @Inject constructor(private val remoteRepository: RemoteDataRepositoryImpl, private val localRepository: LocalData) :
    UseCaseLogin {
    override suspend fun login(login: LoginRequest): Flow<Result<LoginResponse>> {
        return try {
            flow {
                emit(localRepository.doLogin(login))
            }.flowOn(Dispatchers.IO)
        } catch (exception: Exception) {
            Result.Error(exception)
            flow {
                emit(Result.Error(exception))
            }.flowOn(Dispatchers.IO)
        }
    }
}
