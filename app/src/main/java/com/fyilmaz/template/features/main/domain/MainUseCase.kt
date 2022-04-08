package com.fyilmaz.template.features.main.domain

import com.fyilmaz.data.Resource
import com.fyilmaz.data.remote.response.anime.AnimeList
import com.fyilmaz.data.repository.ApiRepository
import javax.inject.Inject

class MainUseCase @Inject constructor(
    val apiRepository: ApiRepository
) {
    suspend fun fetchPopular(): Resource<AnimeList> {
        return apiRepository.fetchPopular()
    }
}
