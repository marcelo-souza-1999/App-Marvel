package com.marcelo.marvel.models

import com.squareup.moshi.Json

data class Thumbs(
    @field:Json(name = "path") val path: String,
    @field:Json(name = "extension") val extension: String,
)