package com.fyilmaz.template.core.data.remote

import com.fyilmaz.template.core.data.dto.movie.MovieResponse
import com.fyilmaz.template.core.data.dto.user.RandomUsers
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    object Api {
        const val apiVersion = "api/"
    }
    @GET(Api.apiVersion)
    suspend fun fetchUsers(
        @Query("page") page: Int = 1,
        @Query("results") results: Int = 10,
    ): Response<RandomUsers>
}
