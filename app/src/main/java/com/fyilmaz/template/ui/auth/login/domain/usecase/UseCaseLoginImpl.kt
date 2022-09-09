package com.fyilmaz.template.ui.auth.login.domain.usecase

import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.login.LoginRequest
import com.fyilmaz.template.core.data.dto.login.LoginResponse
import com.fyilmaz.template.core.data.local.LocalData
import com.fyilmaz.template.core.data.repository.RemoteDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class UseCaseLoginImpl @Inject constructor(private val remoteRepository: RemoteDataRepository, private val localRepository: LocalData, private val coroutine: CoroutineContext) :
    UseCaseLogin {
    override suspend fun login(login: LoginRequest): Flow<Result<LoginResponse>> {
        return flow {
            emit(localRepository.doLogin(login))
        }.flowOn(coroutine)
    }
}
