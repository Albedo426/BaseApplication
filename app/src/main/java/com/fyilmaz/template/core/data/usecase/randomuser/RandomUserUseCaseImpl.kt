package com.fyilmaz.template.core.data.usecase.randomuser

import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.user.RandomUsers
import com.fyilmaz.template.core.data.local.LocalData
import com.fyilmaz.template.core.data.repository.RemoteDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RandomUserUseCaseImpl @Inject constructor(
    private val remoteRepository: RemoteDataRepository,
    private val localRepository: LocalData,
    private val coroutine: CoroutineContext
) :
    RandomUserUseCase {
    override suspend fun fetchData(): Flow<Result<RandomUsers>> {
        return flow {
            emit(remoteRepository.fetchData())
        }.flowOn(coroutine)
    }
}
