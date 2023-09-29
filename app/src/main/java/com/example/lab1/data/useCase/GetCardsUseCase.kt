package com.example.lab1.data.useCase

import androidx.lifecycle.MutableLiveData
import com.example.lab1.data.model.SealedCard

interface GetCardsUseCase {
    val cardsLiveDataSuccess: MutableLiveData<MutableList<SealedCard>>
    val cardsLiveDataFailure: MutableLiveData<Boolean>

    suspend operator fun invoke()
}