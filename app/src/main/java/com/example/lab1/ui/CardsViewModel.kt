package com.example.lab1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab1.data.useCase.GetCardsUseCaseImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

class CardsViewModel @Inject constructor(private val getCardsUseCase: GetCardsUseCaseImpl) : ViewModel() {
    val cardLiveDataSuccess = getCardsUseCase.cardsLiveDataSuccess
    val cardsLiveDataFailure = getCardsUseCase.cardsLiveDataFailure

    fun getCards() {
        viewModelScope.launch { getCardsUseCase() }
    }
}