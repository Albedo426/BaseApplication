package com.fyilmaz.template.core.data.repository

import androidx.paging.PagingSource
import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.error.ErrorMapper
import com.fyilmaz.template.core.data.dto.error.ErrorResponse
import com.fyilmaz.template.core.data.dto.user.RandomUsers
import com.fyilmaz.template.core.data.remote.MovieService
import com.fyilmaz.template.core.netwok.Network
import retrofit2.Response
import java.net.ConnectException

class RemoteDataRepositoryImpl(
    private val service: MovieService,
    private val networkConnectivity: Network
) : RemoteDataRepository {
    override suspend fun fetchData(): Result<RandomUsers> {
        return when (val response = processCall(service::fetchUsers)) {

            is RandomUsers -> Result.Success(data = response)

            is ErrorResponse -> Result.Error(response)

            else -> Result.Error(null)
        }
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!networkConnectivity.isConnected())
            return ErrorMapper.getError(ConnectException())
        return try {
            val response = responseCall.invoke()
            response.body()
        } catch (e: Exception) {
            ErrorMapper.getError(e)
        }
    }
}
