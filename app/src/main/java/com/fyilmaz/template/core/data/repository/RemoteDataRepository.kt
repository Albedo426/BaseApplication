package com.fyilmaz.template.core.data.repository

import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.movie.MovieResponse
import com.fyilmaz.template.core.data.dto.user.RandomUsers

interface RemoteDataRepository {
    suspend fun fetchData(): Result<RandomUsers>
}
