package com.marcelo.marvel.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcelo.marvel.R
import com.marcelo.marvel.domain.models.Hero
import com.marcelo.marvel.domain.models.HeroesResult
import com.marcelo.marvel.data.repository.MarvelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class HeroesViewModel(private val marvelRepository: MarvelRepository) : ViewModel() {

    private val _heroesEvent = MutableLiveData<List<Hero>>()
    val heroEvent: LiveData<List<Hero>>
        get() = _heroesEvent

    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    init {
        getHeroes()
    }

    fun getHeroes() = viewModelScope.launch {

        marvelRepository.getHeroes().collect { result ->

            when(result) {

                is HeroesResult.Success ->{
                    _heroesEvent.value = result.heroes

                    viewFlipperLiveData.value = Pair(VIEW_FLIPPER_HEROES, null)
                }

                is HeroesResult.ApiError -> {
                    if (result.code == R.string.message_error_code_key) {
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.message_error_key)
                    }
                    else {
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.message_error_internal_key)
                    }
                }

                is HeroesResult.NetworkError -> {
                    viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.message_error_internet)
                }

                is HeroesResult.ServerError -> {
                    viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.message_error_server)
                }
            }
        }
    }

    companion object {
        private const val VIEW_FLIPPER_HEROES = 1
        private const val VIEW_FLIPPER_ERROR = 2
    }
}