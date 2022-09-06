package com.fyilmaz.template.core.data.repository

import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.movie.MovieResponse
interface RemoteDataRepository {
    suspend fun fetchData(): Result<MovieResponse>
}
