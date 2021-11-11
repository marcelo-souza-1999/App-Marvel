package com.marcelo.marvel.domain.response

import com.squareup.moshi.Json

data class ErrorResponse(
    @field:Json(name = "message") val message: String
)