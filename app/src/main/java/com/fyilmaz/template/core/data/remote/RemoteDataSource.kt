package com.fyilmaz.template.core.data.remote

import com.fyilmaz.data.Resource
import com.fyilmaz.data.dto.movie.MovieResponse

internal interface RemoteDataSource {
    suspend fun requestRecipes(): Resource<MovieResponse>
}
