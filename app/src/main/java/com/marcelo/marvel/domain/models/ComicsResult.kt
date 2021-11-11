package com.marcelo.marvel.domain.models

sealed class ComicsResult {
    class Success(val comics: List<Comics>) : ComicsResult()
    class ApiError(val code: Int, val message: String?) : ComicsResult()
    class NetworkError(val message: String?) : ComicsResult()
    class ServerError(val message: String?) : ComicsResult()
}