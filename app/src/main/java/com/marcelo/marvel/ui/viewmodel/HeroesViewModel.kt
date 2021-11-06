package com.marcelo.marvel.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcelo.marvel.R
import com.marcelo.marvel.models.Heroes
import com.marcelo.marvel.models.HeroesResult
import com.marcelo.marvel.network.repository.MarvelRepository
import kotlinx.coroutines.launch

class HeroesViewModel(private val marvelRepository: MarvelRepository) : ViewModel() {

    private val _heroesEvent = MutableLiveData<List<Heroes>>()
    val heroesEvent: LiveData<List<Heroes>>
        get() = _heroesEvent

    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    init {
        getHeroes()
    }

    private fun getHeroes() = viewModelScope.launch {

        when (val heroesResult = marvelRepository.getHeroes()) {
            is HeroesResult.Success -> {
                _heroesEvent.value = heroesResult.heroes
                viewFlipperLiveData.value = Pair(VIEW_FLIPPER_HEROES, null)
            }

            is HeroesResult.ApiError -> {
                if (heroesResult.code == R.string.message_error_code_key) {
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

    companion object {
        private const val VIEW_FLIPPER_HEROES = 1
        private const val VIEW_FLIPPER_ERROR = 2
    }
}