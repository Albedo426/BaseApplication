package com.fyilmaz.template.core.data.usecase.movie

import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.movie.MovieResponse
import com.fyilmaz.template.core.data.dto.user.RandomUsers
import kotlinx.coroutines.flow.Flow

interface UseCaseRandomUser {
    suspend fun fetchData(): Flow<Result<RandomUsers>>
}
