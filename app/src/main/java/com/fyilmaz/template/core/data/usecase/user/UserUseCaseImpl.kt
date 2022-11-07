package com.fyilmaz.template.core.data.usecase.user

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

class UserUseCaseImpl @Inject constructor(private val remoteRepository: RemoteDataRepository, private val localRepository: LocalData, private val coroutine: CoroutineContext) :
    UserUseCase {
    override suspend fun login(login: LoginRequest): Flow<Result<LoginResponse>> {
        return flow {
            emit(localRepository.doLogin(login))
        }.flowOn(coroutine)
    }

    override suspend fun getListForTest(): Flow<Result<List<String>>> {
        return flow {
            emit(localRepository.doTest())
        }.flowOn(coroutine)
    }
}
