package com.marcelo.marvel.domain.models

import com.squareup.moshi.Json

data class Heroes(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "thumbnail") val thumbnail: Thumbs
)