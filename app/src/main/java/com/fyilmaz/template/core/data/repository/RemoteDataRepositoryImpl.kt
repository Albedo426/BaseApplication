package com.fyilmaz.template.core.data.repository

import androidx.annotation.VisibleForTesting
import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.movie.MovieResponse
import com.fyilmaz.template.core.data.remote.MovieService

class RemoteDataRepositoryImpl(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    internal val service: MovieService,
) : RemoteDataRepository {
    override suspend fun fetchData(): Result<MovieResponse> {
        return try {
            Result.Success(service.fetchMovie())
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

}
