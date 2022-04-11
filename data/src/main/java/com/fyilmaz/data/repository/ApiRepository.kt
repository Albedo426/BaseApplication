package com.fyilmaz.data.repository

import androidx.annotation.VisibleForTesting
import com.fyilmaz.data.Resource
import com.fyilmaz.data.remote.response.anime.AnimeList
import javax.inject.Inject

class ApiRepository @Inject constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE) // teste kapalı
    private val service: ApiDataSource
) {
    suspend fun fetchPopular(limit: String = "10", offset: String = "0"): Resource<AnimeList> {
        return try {
            Resource.Success(service.fetchAnimeList(limit, offset))
        } catch (exception: Exception) {
            Resource.Error("Animeleri Getirirken Bir Hata Beydana Geldi", error = exception)
        }
    }
}
