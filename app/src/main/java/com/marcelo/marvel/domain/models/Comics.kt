package com.marcelo.marvel.domain.models

import com.squareup.moshi.Json

data class Comics(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "pageCount") val pageCount: Long,
    @field:Json(name = "thumbnail") val thumbnail: Thumbs
)