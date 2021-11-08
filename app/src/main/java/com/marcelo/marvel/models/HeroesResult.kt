package com.marcelo.marvel.models

sealed class HeroesResult {
    class Success(val heroes: List<Heroes>) : HeroesResult()
    class ApiError(val code: Int, val message: String?) : HeroesResult()
    class NetworkError(val message: String?) : HeroesResult()
    class ServerError(val message: String?) : HeroesResult()
}