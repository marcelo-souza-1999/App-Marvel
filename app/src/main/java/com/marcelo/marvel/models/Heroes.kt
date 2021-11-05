package com.marcelo.marvel.models

import com.squareup.moshi.Json

data class Heroes(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "description") val description: String,
    @Json(name = "thumbnail") val thumbnail: Thumbs
)