package com.fyilmaz.template.core.data.repository

import androidx.annotation.VisibleForTesting
import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.error.ErrorResponse
import com.fyilmaz.template.core.data.dto.error.NETWORK_ERROR
import com.fyilmaz.template.core.data.dto.movie.MovieResponse
import com.fyilmaz.template.core.data.remote.MovieService
import com.fyilmaz.template.core.netwok.NetworkConnectivity
import retrofit2.Response
import java.io.IOException
import java.net.ConnectException
import kotlin.coroutines.CoroutineContext

class RemoteDataRepositoryImpl(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    internal val service: MovieService,
    private val networkConnectivity: NetworkConnectivity
) : RemoteDataRepository {
    override suspend fun fetchData(): Result<MovieResponse> {
        return when (val response = processCall(service::fetchMovie)) {
            is MovieResponse -> {
                Result.Success(data = response)
            }
            else -> {
                Result.Error(response as Exception)
            }
        }
    }


    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        return try {
            val response = responseCall.invoke()
            response.body()
        } catch (e: Exception) {
            e
        }
    }
}
