package com.fyilmaz.template.core.data.remote

import com.fyilmaz.data.Resource
import com.fyilmaz.data.dto.movie.MovieResponse
import com.fyilmaz.template.core.data.error.NETWORK_ERROR
import com.fyilmaz.template.core.data.error.NO_INTERNET_CONNECTION
import com.fyilmaz.template.core.data.service.MovieService
import com.fyilmaz.template.core.utils.NetworkConnectivity
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject



class RemoteData @Inject
constructor(private val serviceGenerator: MovieService, private val networkConnectivity: NetworkConnectivity) :
    RemoteDataSource {
    override suspend fun requestRecipes(): Resource<MovieResponse> {
        return when (val response = processCall(serviceGenerator::fetchMovie)) {
            is List<*> -> {
                Resource.Success(data = response as MovieResponse)
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!networkConnectivity.isConnected()) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }
}
