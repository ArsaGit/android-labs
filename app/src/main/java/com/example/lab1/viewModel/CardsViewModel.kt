package com.example.lab1.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab1.api.CardRepository
import com.example.lab1.api.GetCardsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CardsViewModel @Inject constructor(private val getCardsUseCase: GetCardsUseCase) : ViewModel() {
    val cardLiveDataSuccess = getCardsUseCase.cardsLiveDataSuccess
    val cardsLiveDataFailure = getCardsUseCase.cardsLiveDataFailure

    fun getCards() {
        viewModelScope.launch { getCardsUseCase() }
    }
}