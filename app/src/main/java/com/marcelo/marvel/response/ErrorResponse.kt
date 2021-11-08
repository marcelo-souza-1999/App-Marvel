package com.marcelo.marvel.response

import com.squareup.moshi.Json

data class ErrorResponse(
    @field:Json(name = "message") val message: String
)