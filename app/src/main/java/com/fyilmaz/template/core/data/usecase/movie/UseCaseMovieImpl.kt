package com.fyilmaz.template.core.data.usecase.movie

import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.movie.MovieResponse
import com.fyilmaz.template.core.data.local.LocalData
import com.fyilmaz.template.core.data.repository.RemoteDataRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class UseCaseMovieImpl @Inject constructor(
    private val remoteRepository: RemoteDataRepositoryImpl,
    private val localRepository: LocalData,
    private val coroutine: CoroutineContext
) :
    UseCaseMovie {
    override suspend fun fetchData(): Flow<Result<MovieResponse>> {
        return try {
            // local mi sorusu burda sorulabilir
            flow {
                emit(remoteRepository.fetchData())
            }.flowOn(coroutine)
        } catch (exception: Exception) {
            Result.Error(exception)
            flow {
                emit(Result.Error(exception))
            }.flowOn(coroutine)
        }
    }
}
