package com.fyilmaz.data.remote.response

import com.fyilmaz.data.remote.response.anime.AnimeList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    object Anime {
        const val mainPath = "/"
        const val animeList = "api/edge/anime"
    }
    @GET(Anime.animeList)
    suspend fun fetchAnimeList(
        @Query("page[limit]") limit: String,
        @Query("page[offset]") offset: String
    ): AnimeList
}
