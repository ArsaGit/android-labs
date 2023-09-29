package com.example.lab1.data.useCase

import com.example.lab1.data.repo.CardRepository
import javax.inject.Inject

class GetCardsUseCaseImpl @Inject constructor
    (private val cardRepository: CardRepository) : GetCardsUseCase
{
    override val cardsLiveDataSuccess = cardRepository.getCardsLiveDataSuccess()
    override val cardsLiveDataFailure = cardRepository.getCardsLiveDataFailure()

    override suspend operator fun invoke() {
        cardRepository.getCards()
    }
}