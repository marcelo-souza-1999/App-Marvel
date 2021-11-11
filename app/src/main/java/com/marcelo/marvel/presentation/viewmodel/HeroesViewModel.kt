package com.marcelo.marvel.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcelo.marvel.R
import com.marcelo.marvel.data.local.entity.HeroesEntity
import com.marcelo.marvel.domain.models.Heroes
import com.marcelo.marvel.domain.models.HeroesResult
import com.marcelo.marvel.data.repository.MarvelRepository
import kotlinx.coroutines.launch

class HeroesViewModel(private val marvelRepository: MarvelRepository) : ViewModel() {

    private val _heroesEvent = MutableLiveData<List<Heroes>>()
    val heroesEvent: LiveData<List<Heroes>>
        get() = _heroesEvent

    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    init {
        getHeroes()
    }

    private fun insertHeroesDB(heroesEntity: HeroesEntity) = viewModelScope.launch{
        val getRowsModified: Long = marvelRepository.insertHeroes(heroesEntity)
        if (getRowsModified > 0) {
            Log.d("Database", "Heróis salvos na base de dados")
        } else {
            viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR_DATABASE, R.string.message_error_insert_database)
        }
    }

    fun getHeroes() = viewModelScope.launch {

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
        private const val VIEW_FLIPPER_ERROR_DATABASE = 3
    }
}