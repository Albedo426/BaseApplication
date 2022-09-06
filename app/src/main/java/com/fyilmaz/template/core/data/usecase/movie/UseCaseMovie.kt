package com.fyilmaz.template.core.data.usecase.movie

import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.movie.MovieResponse
import kotlinx.coroutines.flow.Flow

interface UseCaseMovie {
    suspend fun fetchData(): Flow<Result<MovieResponse>>
}
