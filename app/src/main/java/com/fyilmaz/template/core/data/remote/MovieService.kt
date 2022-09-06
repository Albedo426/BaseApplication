package com.fyilmaz.template.core.data.remote

import com.fyilmaz.template.core.data.dto.movie.MovieResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query


interface MovieService {
    object Auth {
        const val login = "/login"
    }
    object Discover {
        private const val main = "/discover"
        const val movie = "$main/movie"
    }
    @POST(Discover.movie)
    suspend fun fetchMovie(
        @Query("sort_by") popularity: String = "popularity"
    ): Response<MovieResponse>
}
