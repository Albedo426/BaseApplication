package com.fyilmaz.template.core.data

import com.fyilmaz.data.Resource
import com.fyilmaz.template.core.data.dto.login.LoginRequest
import com.fyilmaz.data.dto.login.LoginResponse
import com.fyilmaz.data.dto.movie.MovieResponse
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {
    suspend fun login(login: LoginRequest): Flow<Resource<LoginResponse>>
    suspend fun fetchData(): Flow<Resource<MovieResponse>>
}
