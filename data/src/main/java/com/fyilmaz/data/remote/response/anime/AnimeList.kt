package com.fyilmaz.data.remote.response.anime


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AnimeList(
    @Json(name = "data")
    val animeList: List<Anime>
) {
    @JsonClass(generateAdapter = true)
    data class Anime(
        @Json(name = "attributes")
        val attributes: Attributes,
        @Json(name = "id")
        val id: String,
        @Json(name = "relationships")
        val relationships: Relationships
    ) {
        @JsonClass(generateAdapter = true)
        data class Attributes(
            @Json(name = "averageRating")
            val averageRating: String,
            @Json(name = "description")
            val description: String,
            @Json(name = "endDate")
            val endDate: String,
            @Json(name = "episodeCount")
            val episodeCount: Int,
            @Json(name = "posterImage")
            val posterImage: PosterImage,
            @Json(name = "slug")
            val slug: String,
            @Json(name = "startDate")
            val startDate: String,
            @Json(name = "status")
            val status: String,
            @Json(name = "synopsis")
            val synopsis: String,
            @Json(name = "totalLength")
            val totalLength: Int
        ) {
            @JsonClass(generateAdapter = true)
            data class PosterImage(
                @Json(name = "original")
                val original: String
            )
        }

        @JsonClass(generateAdapter = true)
        data class Relationships(
            @Json(name = "categories")
            val categories: Categories
        ) {
            @JsonClass(generateAdapter = true)
            data class Categories(
                @Json(name = "links")
                val links: Links
            ) {
                @JsonClass(generateAdapter = true)
                data class Links(
                    @Json(name = "related")
                    val related: String,
                    @Json(name = "self")
                    val self: String
                )
            }
        }
    }
}