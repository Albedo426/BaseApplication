package com.fyilmaz.template.core.data

import com.fyilmaz.data.Resource
import com.fyilmaz.data.dto.login.LoginResponse
import com.fyilmaz.data.dto.movie.MovieResponse
import com.fyilmaz.data.local.LocalData
import com.fyilmaz.template.core.data.dto.login.LoginRequest
import com.fyilmaz.template.core.data.remote.RemoteData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataRepository @Inject constructor(private val remoteRepository: RemoteData, private val localRepository: LocalData, private val ioDispatcher: CoroutineContext) : DataRepositorySource {
    override suspend fun login(login: LoginRequest): Flow<Resource<LoginResponse>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchData(): Flow<Resource<MovieResponse>> {
        TODO("Not yet implemented")
    }

}