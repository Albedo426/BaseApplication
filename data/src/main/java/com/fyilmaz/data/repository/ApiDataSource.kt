package com.fyilmaz.data.repository

import com.fyilmaz.data.remote.response.ApiServices
import javax.inject.Inject

class ApiDataSource @Inject constructor(
    private val apiService: ApiServices
) {

    suspend fun fetchAnimeList(limit: String, offset: String) = apiService.fetchAnimeList(limit, offset)
}
