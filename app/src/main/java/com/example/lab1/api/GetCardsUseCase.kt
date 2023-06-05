package com.example.lab1.api

import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val cardRepository: CardRepository) {
    val cardsLiveDataSuccess = cardRepository.getCardsLiveDataSuccess()
    val cardsLiveDataFailure = cardRepository.getCardsLiveDataFailure()

    suspend operator fun invoke() {
        cardRepository.getCards()
    }
}