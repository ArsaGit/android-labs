package com.example.lab1.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.lab1.data.model.SealedCard

interface CardRepository {
    suspend fun getCards()
    fun getCardsLiveDataSuccess(): MutableLiveData<MutableList<SealedCard>>
    fun getCardsLiveDataFailure(): MutableLiveData<Boolean>
}