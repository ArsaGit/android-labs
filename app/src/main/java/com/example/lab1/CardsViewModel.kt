package com.example.lab1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab1.api.CardRepository
import kotlinx.coroutines.launch

class CardsViewModel : ViewModel() {
    private val cardRepository = CardRepository()

    val cardLiveDataSuccess = cardRepository.cardsLiveDataSuccess
    val cardsLiveDataFailure = cardRepository.cardsLiveDataFailure

    fun getCards() {
        viewModelScope.launch { cardRepository.getCards() }
    }
}