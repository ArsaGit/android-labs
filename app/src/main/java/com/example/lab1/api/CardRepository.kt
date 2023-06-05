package com.example.lab1.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lab1.model.SealedCard
import javax.inject.Inject

class CardRepository @Inject constructor(private val apiService: ApiService) {
    private val cardsLiveDataSuccess: MutableLiveData<MutableList<SealedCard>> = MutableLiveData<MutableList<SealedCard>>()
    private val cardsLiveDataFailure: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    suspend fun getCards() {
        try {
            val response = apiService.getCards()

            if (response.isSuccessful) {
                cardsLiveDataSuccess.postValue(response.body() as MutableList<SealedCard>)
            }
            else{
                cardsLiveDataFailure.postValue(true)
            }
        } catch (e: java.lang.Exception) {
            Log.e(CardRepository::class.java.simpleName, e.message.toString())
        }
    }

    public fun getCardsLiveDataSuccess(): MutableLiveData<MutableList<SealedCard>> {
        return cardsLiveDataSuccess;
    }

    public fun getCardsLiveDataFailure(): MutableLiveData<Boolean> {
        return cardsLiveDataFailure;
    }
}