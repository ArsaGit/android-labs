package com.example.lab1.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lab1.data.api.ApiService
import com.example.lab1.data.model.SealedCard
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(private val apiService: ApiService) : CardRepository{
    private val cardsLiveDataSuccess: MutableLiveData<MutableList<SealedCard>> =
        MutableLiveData<MutableList<SealedCard>>()
    private val cardsLiveDataFailure: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>()

    override suspend fun getCards() {
        try {
            val response = apiService.getCards()

            if (response.isSuccessful) {
                cardsLiveDataSuccess.postValue(response.body() as MutableList<SealedCard>)
            }
            else{
                cardsLiveDataFailure.postValue(true)
            }
        } catch (e: java.lang.Exception) {
            Log.e(CardRepositoryImpl::class.java.simpleName, e.message.toString())
        }
    }

    override fun getCardsLiveDataSuccess(): MutableLiveData<MutableList<SealedCard>> {
        return cardsLiveDataSuccess;
    }

    override fun getCardsLiveDataFailure(): MutableLiveData<Boolean> {
        return cardsLiveDataFailure;
    }
}