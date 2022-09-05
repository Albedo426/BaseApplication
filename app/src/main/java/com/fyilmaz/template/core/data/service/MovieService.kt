package com.fyilmaz.template.core.data.service

import com.fyilmaz.data.dto.movie.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("discover/movie")
    suspend fun fetchMovie(@Query("sort_by") sort: String = "popularity",): Response<MovieResponse>
}
