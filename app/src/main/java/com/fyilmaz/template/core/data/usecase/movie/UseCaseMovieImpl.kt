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

class UseCaseMovieImpl @Inject constructor(private val remoteRepository: RemoteDataRepositoryImpl, private val localRepository: LocalData) :
    UseCaseMovie {
    override suspend fun fetchData(): Flow<Result<MovieResponse>> {
        return try {
            // local mi sorusu burda sorulabilir
            flow {
                emit(remoteRepository.fetchData())
            }.flowOn(Dispatchers.IO)
        } catch (exception: Exception) {
            Result.Error(exception)
            flow {
                emit(Result.Error(exception))
            }.flowOn(Dispatchers.IO)
        }
    }
}
