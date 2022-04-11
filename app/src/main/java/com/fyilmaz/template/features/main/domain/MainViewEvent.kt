package com.fyilmaz.template.features.main.domain

import com.fyilmaz.data.remote.response.anime.AnimeList

sealed class MainViewEvent {
    data class NavigateToDetails(val item: AnimeList.Anime) : MainViewEvent()
}
