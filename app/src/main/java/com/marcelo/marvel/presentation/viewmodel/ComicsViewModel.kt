package com.marcelo.marvel.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcelo.marvel.R
import com.marcelo.marvel.domain.models.Comics
import com.marcelo.marvel.domain.models.ComicsResult
import com.marcelo.marvel.data.repository.MarvelRepository
import kotlinx.coroutines.launch

class ComicsViewModel(private val marvelRepository: MarvelRepository) : ViewModel() {

    private val _comicsEvent = MutableLiveData<List<Comics>>()
    val comicsEvent: LiveData<List<Comics>>
        get() = _comicsEvent

    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    fun getComics(idCharacter: Long) = viewModelScope.launch {

        when (val comicsResult = marvelRepository.getComics(idCharacter)) {
            is ComicsResult.Success -> {
                _comicsEvent.value = comicsResult.comics
                viewFlipperLiveData.value = Pair(VIEW_FLIPPER_COMMICS, null)
            }

            is ComicsResult.ApiError -> {
                if (comicsResult.code == R.string.message_error_code_key) {
                    viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.message_error_key)
                }
                else {
                    viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.message_error_internal_key)
                }
            }

            is ComicsResult.NetworkError -> {
                viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.message_error_internet)
            }

            is ComicsResult.ServerError -> {
                viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.message_error_server)
            }
        }
    }

    companion object {
        private const val VIEW_FLIPPER_COMMICS = 1
        private const val VIEW_FLIPPER_ERROR = 2
    }
}