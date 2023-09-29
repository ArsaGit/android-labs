package com.example.lab1.data.api

import com.example.lab1.data.model.SealedCard
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("new_text.json")
    suspend fun getCards(): Response<MutableList<SealedCard.CardInfo>>
}